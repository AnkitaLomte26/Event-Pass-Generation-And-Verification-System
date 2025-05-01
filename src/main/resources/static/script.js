document.addEventListener('DOMContentLoaded', function() {
    // Add event listeners for the print and email buttons on the event pass page
    const printButton = document.getElementById('print-pass');
    if (printButton) {
        printButton.addEventListener('click', function() {
            window.print();
        });
    }

    const emailButton = document.getElementById('email-pass');
    if (emailButton) {
        emailButton.addEventListener('click', function() {
            // Simple email notification - in a real app, this would call an API
            alert('Your event pass has been sent to your email.');
        });
    }

    // Form validation for registration form
    const registrationForm = document.getElementById('registration-form');
    if (registrationForm) {
        registrationForm.addEventListener('submit', function(event) {
            const paymentOption = document.querySelector('input[name="paymentOption"]:checked').value;
            const paymentProofFile = document.getElementById('paymentProofFile');
            
            // If payment option is not cash, require payment proof
            if (paymentOption !== 'cash' && (!paymentProofFile.files || paymentProofFile.files.length === 0)) {
                event.preventDefault();
                
                const errorElement = document.getElementById('payment-proof-error');
                if (errorElement) {
                    errorElement.textContent = 'Payment proof is required for ' + paymentOption + ' payments.';
                    errorElement.classList.remove('d-none');
                } else {
                    const newError = document.createElement('div');
                    newError.id = 'payment-proof-error';
                    newError.className = 'alert alert-danger mt-2';
                    newError.textContent = 'Payment proof is required for ' + paymentOption + ' payments.';
                    paymentProofFile.parentNode.appendChild(newError);
                }
                
                // Scroll to error
                paymentProofFile.scrollIntoView({ behavior: 'smooth', block: 'center' });
            }
        });
        
        // Show/hide payment proof field based on payment option
        const paymentOptions = document.querySelectorAll('input[name="paymentOption"]');
        const paymentProofContainer = document.getElementById('payment-proof-container');
        
        if (paymentOptions && paymentProofContainer) {
            paymentOptions.forEach(function(option) {
                option.addEventListener('change', function() {
                    if (this.value === 'cash') {
                        paymentProofContainer.classList.add('d-none');
                    } else {
                        paymentProofContainer.classList.remove('d-none');
                    }
                });
            });
        }
    }
});