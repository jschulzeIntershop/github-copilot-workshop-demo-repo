-- Flyway migration script to insert mock data for cat profiles
INSERT INTO cat_profile (name, age, breed, profile_picture) VALUES
('Whiskers', 2, 'Siamese', 'https://example.com/whiskers.jpg'),
('Mittens', 3, 'Persian', 'https://example.com/mittens.jpg'),
('Shadow', 1, 'Maine Coon', 'https://example.com/shadow.jpg');