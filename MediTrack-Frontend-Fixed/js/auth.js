
// LOGIN
const loginForm = document.getElementById('loginForm');
if (loginForm) {
    loginForm.addEventListener('submit', async (e) => {
        e.preventDefault();
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;

        try {
            const res = await fetch('http://localhost:8080/api/auth/login', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ email, password })
            });

            const data = await res.json();

            if (res.ok) {
    
            localStorage.setItem('user', JSON.stringify(data.user));
            alert(data.message || 'Login successful!');
            window.location.href = 'dashboard.html';
            } 
            else {
            alert(data.message || 'Login failed');
            }

        } catch (err) {
            console.error(err);
            alert('Server error. Please try again later.');
        }
    });
}

// REGISTER
const registerForm = document.getElementById('registerForm');
if (registerForm) {
    registerForm.addEventListener('submit', async (e) => {
        e.preventDefault();
        const name = document.getElementById('name').value;
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;

        try {
            const res = await fetch('http://localhost:8080/api/auth/register', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ name, email, password })
            });

            const data = await res.json();

            if (res.ok) {
    // backend now returns { message: "User registered successfully" }
            alert(data.message || 'Registration successful! You can login now.');
            window.location.href = 'index.html';
            } else {
            alert(data.message || 'Registration failed');
}

        } catch (err) {
            console.error(err);
            alert('Server error. Please try again later.');
        }
    });
}
