<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to Our Hotel</title>
    <link rel="stylesheet" href="styles.css">
    <style>
        /* Add your custom CSS styles here */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        header {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 20px;
        }
        .logo {
            width: 150px;
            height: auto;
        }
        nav {
            background-color: #444;
            text-align: center;
            padding: 10px;
        }
        nav a {
            color: #fff;
            text-decoration: none;
            padding: 10px;
            margin: 0 5px;
        }
        nav a:hover {
            background-color: #555;
        }
        main {
            padding: 20px;
        }
        .section {
            margin-bottom: 40px;
        }
        .section h2 {
            font-size: 28px;
            color: #333;
            margin-bottom: 20px;
        }
        .section p {
            font-size: 16px;
            line-height: 1.6;
        }
        .section img {
            max-width: 100%;
            height: auto;
        }
        footer {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 20px;
        }
    </style>
</head>
<body>
    <header>
        <img src="logo.png" alt="Hotel Logo" class="logo">
    </header>
    <nav>
        <a href="home.jsp">Home</a>
        <a href="search-rooms.jsp">Search Rooms</a>
        <a href="reservation-history.jsp">Reservation History</a>
    </nav>
    <main>
        <section id="about" class="section animate">
            <h2>About Us</h2>
            <p>Welcome to our hotel reservation system. We provide a convenient way for you to browse available rooms, make reservations, and manage your bookings.</p>
        </section>
        <section id="services" class="section animate">
            <h2>Our Services</h2>
            <ul>
                <li>24/7 Room Availability</li>
                <li>Online Reservation System</li>
                <li>Discounts and Offers</li>
                <li>Free Wi-Fi in All Rooms</li>
                <!-- Add more services as needed -->
            </ul>
        </section>
        <section id="contact" class="section animate">
            <h2>Contact Us</h2>
            <p>If you have any questions or need assistance, feel free to contact our customer service team.</p>
            <p>Phone: 123-456-7890</p>
            <p>Email: info@example.com</p>
        </section>
    </main>
    <footer>
        &copy; 2022 Our Hotel. All rights reserved.
    </footer>
    <script>
        // Add animation to sections when scrolling into view
        window.addEventListener('scroll', () => {
            const sections = document.querySelectorAll('.animate');
            sections.forEach(section => {
                if (isElementInViewport(section)) {
                    section.classList.add('fadeIn');
                }
            });
        });

        // Helper function to check if element is in viewport
        function isElementInViewport(el) {
            const rect = el.getBoundingClientRect();
            return (
                rect.top >= 0 &&
                rect.left >= 0 &&
                rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) &&
                rect.right <= (window.innerWidth || document.documentElement.clientWidth)
            );
        }
    </script>
</body>
</html>
