CREATE TABLE adresses (
                          id INTEGER PRIMARY KEY,
                          ligne1 VARCHAR(255),
                          ville VARCHAR(255),
                          code_postal VARCHAR(255)
);

CREATE TABLE centres (
                         id INTEGER PRIMARY KEY,
                         nom VARCHAR(255),
                         adresse_id INTEGER,
                         telephone VARCHAR(255),
                         FOREIGN KEY (adresse_id) REFERENCES adresses(id)
);

CREATE TABLE specialites (
                             id INTEGER PRIMARY KEY,
                             nom VARCHAR(255)
);

CREATE TABLE medecins (
                          id INTEGER PRIMARY KEY,
                          prenom VARCHAR(255),
                          nom VARCHAR(255),
                          centre_id INTEGER,
                          adresse_id INTEGER,
                          specialite_id INTEGER,
                          FOREIGN KEY (centre_id) REFERENCES centres(id),
                          FOREIGN KEY (adresse_id) REFERENCES adresses(id),
                          FOREIGN KEY (specialite_id) REFERENCES specialites(id)
);

CREATE TABLE patients (
                          id INTEGER PRIMARY KEY,
                          prenom VARCHAR(255),
                          nom VARCHAR(255),
                          date_de_naissance TIMESTAMP(6),
                          adresse_id INTEGER,
                          medecin_id INTEGER,
                          FOREIGN KEY (adresse_id) REFERENCES adresses(id),
                          FOREIGN KEY (medecin_id) REFERENCES medecins(id)
);

CREATE TABLE consultations (
                               id INTEGER PRIMARY KEY,
                               medecin_id INTEGER,
                               patient_id INTEGER,
                               centre_id INTEGER,
                               date DATE,
                               heure VARCHAR(255),
                               statut VARCHAR(255),
                               FOREIGN KEY (medecin_id) REFERENCES medecins(id),
                               FOREIGN KEY (patient_id) REFERENCES patients(id),
                               FOREIGN KEY (centre_id) REFERENCES centres(id)
);

CREATE TABLE utilisateurs (
                              email INTEGER PRIMARY KEY,
                              is_user BOOLEAN,
                              is_doctor BOOLEAN,
                              is_admin BOOLEAN
);




