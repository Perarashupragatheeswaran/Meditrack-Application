
const appointmentForm = document.getElementById('appointmentForm');
const appointmentsList = document.getElementById('appointmentsList');
const user = JSON.parse(localStorage.getItem('user'));


async function loadAppointments() {
    try {
        const res = await fetch('http://localhost:8080/api/appointments', {
            headers: { 'Authorization': `Bearer ${user.token || ''}` }
        });
        const data = await res.json();
        appointmentsList.innerHTML = '';
        data.forEach(a => {
            const div = document.createElement('div');
            div.className = 'appointment-card';
            div.innerHTML = `<span>${a.doctor} - ${new Date(a.date).toLocaleDateString()}</span>`;
            appointmentsList.appendChild(div);
        });
    } catch (err) { console.error(err); }
}

appointmentForm.addEventListener('submit', async e => {
    e.preventDefault();
    const doctor = document.getElementById('doctor').value;
    const date = document.getElementById('date').value;
    try {
        const res = await fetch('http://localhost:8080/api/appointments', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${user.token || ''}`
            },
            body: JSON.stringify({ doctor, date })
        });
        if (res.ok) { loadAppointments(); appointmentForm.reset(); }
    } catch (err) { console.error(err); }
});

loadAppointments();
