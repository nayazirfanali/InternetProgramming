<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RentRide Vehicle Rental System</title>
    <link rel="stylesheet" href="style1.css">
    <script src="script.js" defer></script>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        header {
            text-align: center;
            padding: 20px;
            background: #007BFF;
            color: white;
        }
        nav ul {
            display: flex;
            justify-content: center;
            list-style-type: none;
            background: #333;
            padding: 0;
        }
        nav ul li {
            margin: 0 15px;
        }
        nav ul li a {
            color: white;
            text-decoration: none;
            padding: 10px 20px;
            display: block;
        }
        nav ul li a:hover {
            background: #575757;
        }
        main {
            padding: 20px;
        }
        .form-section {
            max-width: 500px;
            margin: 20px auto;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input,
        .form-group select,
        .form-group textarea {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }
        footer {
            text-align: center;
            padding: 10px;
            background: #007BFF;
            color: white;
            position: fixed;
            width: 100%;
            bottom: 0;
        }
    </style>
</head>
<body>
    <!-- Login Form -->
    <div id="login-form" class="form-section">
        <h1>Login</h1>
        <form id="login" onsubmit="return authenticate(event)">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <input type="submit" value="Login">
        </form>
    </div>

    <!-- Frontend Page -->
    <div id="main-content" style="display: none;">
        <header>
            <h1>Welcome to RentRide</h1>
            <p>Welcome, <span id="user-display"></span> | <a href="#" onclick="logout()">Logout</a></p>
        </header>
        <nav>
            <ul>
                <li><a href="#home" onclick="showSection('home')">Home</a></li>
                <li><a href="#vehicles" onclick="showSection('vehicles')">Vehicles</a></li>
                <li><a href="#bookings" onclick="showSection('bookings')">Bookings</a></li>
                <li><a href="#billing" onclick="showSection('billing')">Billing</a></li>
                <li><a href="#contact" onclick="showSection('contact')">Contact</a></li>
            </ul>
        </nav>
        <main>
            <!-- Home Section -->
            <section id="home" class="section-content">
                <h2>Welcome to RentRide</h2>
                <p>Your convenient vehicle rental solution.</p>
            </section>

            <!-- Vehicles Section -->
            <section id="vehicles" class="section-content">
                <h2>Available Vehicles</h2>
                <p>Browse our diverse fleet of cars, trucks, and SUVs.</p>
            </section>

            <!-- Bookings Section -->
            <section id="bookings" class="section-content">
                <h2>Your Bookings</h2>
                <form id="bookings-form" class="form-section" action="process_form.php" method="POST">
                    <input type="hidden" name="form_type" value="bookings">
                    <div class="form-group">
                        <label for="vehicle-name">Vehicle Name:</label>
                        <input type="text" id="vehicle-name" name="vehicle-name" required>
                    </div>
                    <div class="form-group">
                        <label for="rental-duration">Rental Duration (days):</label>
                        <input type="number" id="rental-duration" name="rental-duration" required>
                    </div>
                    <div class="form-group">
                        <label for="pickup-location">Pickup Location:</label>
                        <input type="text" id="pickup-location" name="pickup-location" required>
                    </div>
                    <input type="submit" value="Submit">
                </form>
            </section>

            <!-- Billing Section -->
            <section id="billing" class="section-content">
                <h2>Billing</h2>
                <form id="billing-form" class="form-section" action="process_form.php" method="POST">
                    <input type="hidden" name="form_type" value="billing">
                    <div class="form-group">
                        <label for="billing-amount">Amount:</label>
                        <input type="number" id="billing-amount" name="billing-amount" required>
                    </div>
                    <div class="form-group">
                        <label for="billing-method">Payment Method:</label>
                        <select id="billing-method" name="billing-method" required>
                            <option value="credit">Credit Card</option>
                            <option value="debit">Debit Card</option>
                            <option value="cash">Cash</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="billing-notes">Notes:</label>
                        <textarea id="billing-notes" name="billing-notes" rows="4"></textarea>
                    </div>
                    <input type="submit" value="Submit">
                </form>
            </section>

            <!-- Contact Section -->
            <section id="contact" class="section-content">
                <h2>Contact Us</h2>
                <form id="contact-form" class="form-section" action="process_form.php" method="POST">
                    <input type="hidden" name="form_type" value="contact">
                    <div class="form-group">
                        <label for="contact-name">Name:</label>
                        <input type="text" id="contact-name" name="contact-name" required>
                    </div>
                    <div class="form-group">
                        <label for="contact-email">Email:</label>
                        <input type="email" id="contact-email" name="contact-email" required>
                    </div>
                    <div class="form-group">
                        <label for="contact-message">Message:</label>
                        <textarea id="contact-message" name="contact-message" rows="4" required></textarea>
                    </div>
                    <input type="submit" value="Submit">
                </form>
            </section>
        </main>
    </div>

    <footer>
        <p>&copy; 2024 RentRide Vehicle Rental System</p>
    </footer>

    <script>
        function authenticate(event) {
            event.preventDefault();
            const username = document.getElementById('username').value;
            const password = document.getElementById('password').value;

            if (username === 'admin' && password === 'password') { // Example credentials
                document.getElementById('login-form').style.display = 'none';
                document.getElementById('main-content').style.display = 'block';
                document.getElementById('user-display').textContent = username;
            } else {
                alert('Invalid username or password');
            }
        }

        function logout() {
            document.getElementById('login-form').style.display = 'block';
            document.getElementById('main-content').style.display = 'none';
        }

        function showSection(sectionId) {
            document.querySelectorAll('.section-content').forEach(section => {
                section.style.display = 'none';
            });
            document.getElementById(sectionId).style.display = 'block';
        }

        document.addEventListener('DOMContentLoaded', () => {
            showSection('home');
        });
    </script>
</body>
</html>
