const axios = require('axios'); // Si vous êtes dans un environnement Node.js

const firstnames = ["Jean", "Marie", "Sophie", "Pierre", "Paul"]
const lastnames = ["Dupont", "Martin", "Dubois", "Lefebvre", "Durand"];
const cities = ["Paris", "Lyon", "Marseille", "Toulouse", "Bordeaux"];
const streets = ["rue de la Paix", "avenue Victor Hugo", "boulevard Saint-Germain", "rue du Faubourg Saint-Honoré", "place de la Concorde"];


async function createDoctor() {

  const randomFirstname = firstnames[Math.floor(Math.random() * firstnames.length)];
  const randomLastname = lastnames[Math.floor(Math.random() * lastnames.length)];
  const randomCity = cities[Math.floor(Math.random() * cities.length)];
  const randomStreet = streets[Math.floor(Math.random() * streets.length)];
  const randomPostalCode = Math.floor(10000 + Math.random() * 90000).toString(); // Code postal aléatoire

  const doctor = {
    firstname: randomFirstname,
    lastname: randomLastname,
    address: {
      city: randomCity,
      postalCode: randomPostalCode,
      street: randomStreet
    }
  };

  try {
    const response = await axios.post('http://localhost:8080/doctors', doctor, {
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJncmVnb2lyZWJhdW1hbm45NEBnbWFpbC5jb20iLCJpc3MiOiJDaHJvbm9WYWNjaW4iLCJyb2xlcyI6Ik9JRENfVVNFUixTQ09QRV9odHRwczovL3d3dy5nb29nbGVhcGlzLmNvbS9hdXRoL3VzZXJpbmZvLmVtYWlsLFNDT1BFX2h0dHBzOi8vd3d3Lmdvb2dsZWFwaXMuY29tL2F1dGgvdXNlcmluZm8ucHJvZmlsZSxTQ09QRV9vcGVuaWQiLCJpYXQiOjE3NDA3NjE3OTksImV4cCI6MTc0MDg0ODE5OX0.uFzu8TGZHQb0-amG037mRbeRfV-nLP67p0pC5ppXawE'
      }
    });
    console.log(response.status)
    if (response.status === 201) {
      console.log('Médecin créé avec succès !');
    } else {
      console.error('Erreur lors de la création du médecin:', response.status);
    }
  } catch (error) {
    console.error('Erreur lors de la requête:', error);
  }
}

// Créer plusieurs médecins
for (let i = 0; i < 10; i++) { // Créer 10 médecins
  createDoctor();
}