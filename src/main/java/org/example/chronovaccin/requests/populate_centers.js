const axios = require('axios');

// Listes de données aléatoires
const hopitaux = ["Hôpital Saint-Louis", "Hôpital Necker", "Hôpital Cochin", "Hôpital Bichat", "Hôpital Beaujon"];
const villes = ["Paris", "Lyon", "Marseille", "Toulouse", "Bordeaux"];
const codesPostaux = ["75000", "69000", "13000", "31000", "33000"];
const rues = ["rue de la Paix", "avenue des Champs-Élysées", "boulevard Saint-Germain", "rue de Rivoli", "place de la Concorde"];

// Fonction pour créer un centre de vaccination avec des données aléatoires
async function creerCentreVaccination() {
  const nomHopital = hopitaux[Math.floor(Math.random() * hopitaux.length)];
  const ville = villes[Math.floor(Math.random() * villes.length)];
  const codePostal = codesPostaux[Math.floor(Math.random() * codesPostaux.length)];
  const rue = rues[Math.floor(Math.random() * rues.length)];

  const data = {
    name: nomHopital,
    address: {
      city: ville,
      postalCode: codePostal,
      street: rue
    }
  };

  console.log(data)

  try {
    const response = await axios.post("http://localhost:8080/centers", data, {
      headers: {
        'Content-Type': 'application/json'
      }
    });
    console.log(response.status);
    console.log(response.data);
  } catch (error) {
    console.error("Erreur lors de la création du centre de vaccination :", error);
  }
}

// Créer 10 centres de vaccination
async function creerCentres() {
  for (let i = 0; i < 10; i++) {
    await creerCentreVaccination();
  }
}

creerCentres();