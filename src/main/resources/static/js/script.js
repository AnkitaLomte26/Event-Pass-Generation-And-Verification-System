/**
 * Main JavaScript file for the Event Registration System
 */
document.addEventListener('DOMContentLoaded', function() {
    // Add event listeners for the print button in event pass page
    const printButton = document.getElementById('print-event-pass');
    if (printButton) {
        printButton.addEventListener('click', function() {
            window.print();
        });
    }
    
    // Add event listeners for payment option toggle
    const paymentOptions = document.querySelectorAll('input[name="paymentOption"]');
    const paymentProofSection = document.getElementById('payment-proof-section');
    
    if (paymentOptions && paymentProofSection) {
        paymentOptions.forEach(option => {
            option.addEventListener('change', function() {
                if (this.value === 'cash') {
                    paymentProofSection.style.display = 'none';
                } else {
                    paymentProofSection.style.display = 'block';
                }
            });
        });
    }
    
    // Form validation
    const registrationForm = document.getElementById('registration-form');
    if (registrationForm) {
        registrationForm.addEventListener('submit', function(e) {
            // Get all required fields
            const requiredFields = registrationForm.querySelectorAll('[required]');
            let formValid = true;
            
            // Check for empty required fields
            requiredFields.forEach(field => {
                if (!field.value.trim()) {
                    formValid = false;
                    // Add error class to highlight the field
                    field.classList.add('error-field');
                    
                    // Create error message if it doesn't exist
                    let errorMessage = field.parentElement.querySelector('.error-message');
                    if (!errorMessage) {
                        errorMessage = document.createElement('div');
                        errorMessage.className = 'error-message';
                        field.parentElement.appendChild(errorMessage);
                    }
                    errorMessage.textContent = 'This field is required';
                } else {
                    // Remove error class and message if field is valid
                    field.classList.remove('error-field');
                    const errorMessage = field.parentElement.querySelector('.error-message');
                    if (errorMessage) {
                        errorMessage.remove();
                    }
                }
            });
            
            // Email validation
            const emailField = document.getElementById('email');
            if (emailField && emailField.value.trim()) {
                const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
                if (!emailPattern.test(emailField.value.trim())) {
                    formValid = false;
                    emailField.classList.add('error-field');
                    
                    // Create error message if it doesn't exist
                    let errorMessage = emailField.parentElement.querySelector('.error-message');
                    if (!errorMessage) {
                        errorMessage = document.createElement('div');
                        errorMessage.className = 'error-message';
                        emailField.parentElement.appendChild(errorMessage);
                    }
                    errorMessage.textContent = 'Please enter a valid email address';
                }
            }
            
            // Phone number validation
            const phoneField = document.getElementById('mobile');
            if (phoneField && phoneField.value.trim()) {
                const phonePattern = /^\d{10}$/;
                if (!phonePattern.test(phoneField.value.trim())) {
                    formValid = false;
                    phoneField.classList.add('error-field');
                    
                    // Create error message if it doesn't exist
                    let errorMessage = phoneField.parentElement.querySelector('.error-message');
                    if (!errorMessage) {
                        errorMessage = document.createElement('div');
                        errorMessage.className = 'error-message';
                        phoneField.parentElement.appendChild(errorMessage);
                    }
                    errorMessage.textContent = 'Please enter a valid 10-digit mobile number';
                }
            }
            
            // Payment proof validation
            const paymentOption = document.querySelector('input[name="paymentOption"]:checked');
            const paymentProofFile = document.getElementById('paymentProofFile');
            
            if (paymentOption && paymentOption.value !== 'cash' && paymentProofFile && !paymentProofFile.files.length) {
                formValid = false;
                paymentProofFile.classList.add('error-field');
                
                // Create error message if it doesn't exist
                let errorMessage = paymentProofFile.parentElement.querySelector('.error-message');
                if (!errorMessage) {
                    errorMessage = document.createElement('div');
                    errorMessage.className = 'error-message';
                    paymentProofFile.parentElement.appendChild(errorMessage);
                }
                errorMessage.textContent = 'Payment proof is required for non-cash payments';
            }
            
            // If form is not valid, prevent submission
            if (!formValid) {
                e.preventDefault();
                
                // Scroll to the first error
                const firstError = document.querySelector('.error-field');
                if (firstError) {
                    firstError.scrollIntoView({ behavior: 'smooth', block: 'center' });
                    firstError.focus();
                }
            }
        });
        
        // Remove error class on input
        const formInputs = registrationForm.querySelectorAll('input, select, textarea');
        formInputs.forEach(input => {
            input.addEventListener('input', function() {
                this.classList.remove('error-field');
                const errorMessage = this.parentElement.querySelector('.error-message');
                if (errorMessage) {
                    errorMessage.remove();
                }
            });
        });
    }
    
    // File input preview
    const fileInput = document.getElementById('paymentProofFile');
    const filePreview = document.getElementById('file-preview');
    
    if (fileInput && filePreview) {
        fileInput.addEventListener('change', function() {
            if (this.files && this.files[0]) {
                const reader = new FileReader();
                
                reader.onload = function(e) {
                    filePreview.innerHTML = '';
                    
                    // Check if it's an image file
                    if (fileInput.files[0].type.startsWith('image/')) {
                        const img = document.createElement('img');
                        img.src = e.target.result;
                        img.className = 'file-preview-image';
                        filePreview.appendChild(img);
                    } else {
                        // For non-image files, show file name
                        const fileInfo = document.createElement('div');
                        fileInfo.className = 'file-info';
                        fileInfo.textContent = fileInput.files[0].name;
                        filePreview.appendChild(fileInfo);
                    }
                    
                    filePreview.style.display = 'block';
                };
                
                reader.readAsDataURL(this.files[0]);
            } else {
                filePreview.style.display = 'none';
                filePreview.innerHTML = '';
            }
        });
    }
    
    // Countdown timer for locked events
    const lockedEventCountdowns = document.querySelectorAll('.locked-event-countdown');
    
    if (lockedEventCountdowns.length > 0) {
        lockedEventCountdowns.forEach(countdownElement => {
            const unlockDate = new Date(countdownElement.getAttribute('data-unlock-date'));
            
            // Update countdown every second
            const countdownInterval = setInterval(function() {
                const now = new Date().getTime();
                const distance = unlockDate - now;
                
                // Time calculations
                const days = Math.floor(distance / (1000 * 60 * 60 * 24));
                const hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                const minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
                const seconds = Math.floor((distance % (1000 * 60)) / 1000);
                
                // Display countdown
                countdownElement.innerHTML = `Registration opens in: ${days}d ${hours}h ${minutes}m ${seconds}s`;
                
                // If countdown is over
                if (distance < 0) {
                    clearInterval(countdownInterval);
                    countdownElement.innerHTML = "Registration is now open!";
                    
                    // Refresh the page to update event status
                    setTimeout(function() {
                        window.location.reload();
                    }, 3000);
                }
            }, 1000);
        });
    }
    
    // Toggle mobile navigation
    const menuToggle = document.getElementById('menu-toggle');
    const mobileMenu = document.getElementById('mobile-menu');
    
    if (menuToggle && mobileMenu) {
        menuToggle.addEventListener('click', function() {
            mobileMenu.classList.toggle('active');
            menuToggle.classList.toggle('active');
        });
    }
    
    // Add smooth scrolling for anchor links
    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', function(e) {
            e.preventDefault();
            
            const targetId = this.getAttribute('href');
            if (targetId === '#') return;
            
            const targetElement = document.querySelector(targetId);
            if (targetElement) {
                targetElement.scrollIntoView({
                    behavior: 'smooth',
                    block: 'start'
                });
                
                // Close mobile menu if open
                if (mobileMenu && mobileMenu.classList.contains('active')) {
                    mobileMenu.classList.remove('active');
                    menuToggle.classList.remove('active');
                }
            }
        });
    });
});