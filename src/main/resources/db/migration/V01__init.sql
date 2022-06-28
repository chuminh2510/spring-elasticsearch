CREATE TABLE IF NOT EXISTS public.machines
(
    id SERIAL NOT NULL,
    code character(3) COLLATE pg_catalog."default",
    name character varying(80) COLLATE pg_catalog."default",
    created_at time with time zone NOT NULL DEFAULT now(),
    updated_at time with time zone,
                        CONSTRAINT machines_pkey PRIMARY KEY (id)
    ) TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.machines
    OWNER to machine;
