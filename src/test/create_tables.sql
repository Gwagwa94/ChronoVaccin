-- Table: public.adresses

-- DROP TABLE IF EXISTS public.adresses;

CREATE TABLE IF NOT EXISTS public.adresses
(
    id integer NOT NULL,
    ligne1 character varying(255) COLLATE pg_catalog."default" NOT NULL,
    ville character varying(255) COLLATE pg_catalog."default" NOT NULL,
    code_postal character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT adresses_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.adresses
    OWNER to super_admin;

-- Table: public.centres

-- DROP TABLE IF EXISTS public.centres;

CREATE TABLE IF NOT EXISTS public.centres
(
    id integer NOT NULL,
    nom character varying(255) COLLATE pg_catalog."default" NOT NULL,
    adresse_id integer NOT NULL,
    telephone character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT centre_pkey PRIMARY KEY (id),
    CONSTRAINT centre_adresse_id_fkey FOREIGN KEY (adresse_id)
        REFERENCES public.adresses (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.centres
    OWNER to super_admin;

-- Table: public.specialites

-- DROP TABLE IF EXISTS public.specialites;

CREATE TABLE IF NOT EXISTS public.specialites
(
    id integer NOT NULL,
    nom character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT specialites_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.specialites
    OWNER to super_admin;

-- Table: public.medecins

-- DROP TABLE IF EXISTS public.medecins;

CREATE TABLE IF NOT EXISTS public.medecins
(
    id integer NOT NULL,
    prenom character varying(255) COLLATE pg_catalog."default" NOT NULL,
    nom character varying(255) COLLATE pg_catalog."default" NOT NULL,
    centre_id integer,
    adresse_id integer,
    specialite_id integer,
    CONSTRAINT medecins_pkey PRIMARY KEY (id),
    CONSTRAINT medecins_adresse_id_fkey FOREIGN KEY (adresse_id)
        REFERENCES public.adresses (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT medecins_centre_id_fkey FOREIGN KEY (centre_id)
        REFERENCES public.centres (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT medecins_specialite_id_fkey FOREIGN KEY (specialite_id)
        REFERENCES public.specialites (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.medecins
    OWNER to super_admin;

-- Table: public.patients

-- DROP TABLE IF EXISTS public.patients;

CREATE TABLE IF NOT EXISTS public.patients
(
    id integer NOT NULL,
    prenom character varying(255) COLLATE pg_catalog."default" NOT NULL,
    nom character varying(255) COLLATE pg_catalog."default" NOT NULL,
    date_de_naissance timestamp(6) without time zone,
    adresse_id integer,
    medecin_id integer,
    CONSTRAINT patients_pkey PRIMARY KEY (id),
    CONSTRAINT patients_adresse_id_fkey FOREIGN KEY (adresse_id)
        REFERENCES public.adresses (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT patients_medecin_id_fkey FOREIGN KEY (medecin_id)
        REFERENCES public.medecins (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.patients
    OWNER to super_admin;

-- Table: public.consultations

-- DROP TABLE IF EXISTS public.consultations;

CREATE TABLE IF NOT EXISTS public.consultations
(
    id integer NOT NULL,
    medecin_id integer NOT NULL,
    patient_id integer NOT NULL,
    centre_id integer NOT NULL,
    date date NOT NULL,
    heure character varying(255) COLLATE pg_catalog."default" NOT NULL,
    statut character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT consultations_pkey PRIMARY KEY (id),
    CONSTRAINT consultations_centre_id_fkey FOREIGN KEY (centre_id)
        REFERENCES public.centres (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT consultations_medecin_id_fkey FOREIGN KEY (medecin_id)
        REFERENCES public.medecins (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT consultations_patient_id_fkey FOREIGN KEY (patient_id)
        REFERENCES public.patients (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.consultations
    OWNER to super_admin;