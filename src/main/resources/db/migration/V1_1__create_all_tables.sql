--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5 (Debian 14.5-1.pgdg110+1)
-- Dumped by pg_dump version 14.4

-- Started on 2022-10-28 13:17:23 UTC

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

-- CREATE SCHEMA public;
-- ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 3457 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

-- COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 211 (class 1259 OID 78404)
-- Name: account; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.account (
    id uuid NOT NULL,
    annualrevenue integer NOT NULL,
    createdat timestamp without time zone,
    description character varying(255),
    headcount integer NOT NULL,
    name character varying(255),
    updatedat timestamp without time zone,
    website character varying(255),
    assignedto_id uuid,
    billingaddress_id uuid,
    industry_id uuid,
    officephone_id uuid,
    primaryemail_id uuid,
    shippingaddress_id uuid,
    type_id uuid
);


ALTER TABLE public.account OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 78411)
-- Name: account_emailaddress; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.account_emailaddress (
    account_id uuid NOT NULL,
    alternateemails_id uuid NOT NULL
);


ALTER TABLE public.account_emailaddress OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 78414)
-- Name: account_individual; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.account_individual (
    account_id uuid NOT NULL,
    contacts_id uuid NOT NULL
);


ALTER TABLE public.account_individual OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 78417)
-- Name: address; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.address (
    id uuid NOT NULL,
    city character varying(255),
    country character varying(255),
    postalcode character varying(255),
    state character varying(255),
    street character varying(255)
);


ALTER TABLE public.address OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 78424)
-- Name: emailaddress; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.emailaddress (
    id uuid NOT NULL,
    email character varying(255),
    invalid boolean NOT NULL,
    optout boolean NOT NULL
);


ALTER TABLE public.emailaddress OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 78429)
-- Name: employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee (
    id uuid NOT NULL,
    created timestamp without time zone,
    firstname character varying(255),
    jobtitle character varying(255),
    lastname character varying(255),
    mp_invalid boolean,
    mp_number character varying(255),
    notes text,
    op_invalid boolean,
    op_number character varying(255),
    pa_city character varying(255),
    pa_country character varying(255),
    pa_postal_code character varying(255),
    pa_state character varying(255),
    pa_street character varying(255),
    updated timestamp without time zone,
    department_id uuid,
    primaryemail_id uuid,
    reportsto_id uuid,
    status_id uuid
);


ALTER TABLE public.employee OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 78436)
-- Name: employee_emailaddress; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee_emailaddress (
    employee_id uuid NOT NULL,
    alternateemails_id uuid NOT NULL
);


ALTER TABLE public.employee_emailaddress OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 48211)
-- Name: employee_employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee_employee (
    employee_id uuid NOT NULL,
    subordinates_id uuid NOT NULL
);


ALTER TABLE public.employee_employee OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 78439)
-- Name: enumeration; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.enumeration (
    dtype character varying(31) NOT NULL,
    id uuid NOT NULL,
    name character varying(255)
);


ALTER TABLE public.enumeration OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16469)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 78444)
-- Name: individual; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.individual (
    dtype character varying(31) NOT NULL,
    id uuid NOT NULL,
    createdat timestamp without time zone,
    department character varying(255),
    description character varying(255),
    firstname character varying(255),
    jobtitle character varying(255),
    lastname character varying(255),
    updatedat timestamp without time zone,
    assistantname character varying(255),
    birthday date,
    opportunityamount integer,
    account_id uuid,
    alternateaddress_id uuid,
    assignedto_id uuid,
    leadsource_id uuid,
    mobilephone_id uuid,
    officephone_id uuid,
    primaryaddress_id uuid,
    primaryemail_id uuid,
    assistantphone_id uuid,
    reportsto_id uuid,
    status_id uuid
);


ALTER TABLE public.individual OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 78451)
-- Name: individual_emailaddress; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.individual_emailaddress (
    individual_id uuid NOT NULL,
    alternateemails_id uuid NOT NULL
);


ALTER TABLE public.individual_emailaddress OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 78454)
-- Name: opportunity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.opportunity (
    id uuid NOT NULL,
    amount integer NOT NULL,
    description character varying(255),
    expectedclosedate date,
    name character varying(255),
    nextstep character varying(255),
    probability integer NOT NULL,
    account_id uuid,
    assignedto_id uuid,
    leadsource_id uuid,
    salesstage_id uuid,
    type_id uuid
);


ALTER TABLE public.opportunity OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 78461)
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    id uuid NOT NULL,
    name character varying(255)
);


ALTER TABLE public.role OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 78466)
-- Name: security_users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.security_users (
    id uuid NOT NULL,
    name character varying(255),
    password character varying(255),
    username character varying(255)
);


ALTER TABLE public.security_users OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 78473)
-- Name: security_users_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.security_users_role (
    user_id uuid NOT NULL,
    roles_id uuid NOT NULL
);


ALTER TABLE public.security_users_role OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 78476)
-- Name: telephonenumber; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.telephonenumber (
    id uuid NOT NULL,
    invalid boolean NOT NULL,
    number character varying(255)
);


ALTER TABLE public.telephonenumber OWNER TO postgres;

--
-- TOC entry 3437 (class 0 OID 78404)
-- Dependencies: 211
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.account (id, annualrevenue, createdat, description, headcount, name, updatedat, website, assignedto_id, billingaddress_id, industry_id, officephone_id, primaryemail_id, shippingaddress_id, type_id) FROM stdin;
\.


--
-- TOC entry 3438 (class 0 OID 78411)
-- Dependencies: 212
-- Data for Name: account_emailaddress; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.account_emailaddress (account_id, alternateemails_id) FROM stdin;
\.


--
-- TOC entry 3439 (class 0 OID 78414)
-- Dependencies: 213
-- Data for Name: account_individual; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.account_individual (account_id, contacts_id) FROM stdin;
\.


--
-- TOC entry 3440 (class 0 OID 78417)
-- Dependencies: 214
-- Data for Name: address; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.address (id, city, country, postalcode, state, street) FROM stdin;
\.


--
-- TOC entry 3441 (class 0 OID 78424)
-- Dependencies: 215
-- Data for Name: emailaddress; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.emailaddress (id, email, invalid, optout) FROM stdin;
8cb70af2-79e9-444a-949c-5ef85d00c327	big.boss@mycompany.com	f	f
494756e8-be78-414d-9318-15519294efaa	big.loh@mycompany.com	f	f
c16727bd-c66f-4756-9490-2790d86969cb	a@mycompany.com	f	f
30faa725-ca0c-4180-902f-48e7665e1ea4	b@mycompany.com	f	f
5f2ce41f-ebff-41e8-affa-b8b3c0daf320	c@mycompany.com	f	f
f5e55934-f102-4fab-b643-57457887ec91	adam@mycompany.com	f	f
b7d96e48-73a9-4460-bc30-4b7125554b6f	felix@mycompany.com	f	f
1ab16634-2ee7-4d1b-b29b-ae096bb3e9b7	kumar@mycompany.com	f	f
6e544c06-7d6a-4b41-bfc9-c11e761b12e9	anton@mycompany.com	f	f
a736905f-f39a-4952-ac4f-79803786f461	joanna@mycompany.com	f	f
bbb0ba17-215f-4ebb-a33e-a11b01cbcc3c	glenn@mycompany.com	f	f
40293784-fe05-445c-8bb3-9fcbaea59fe5	hanna@mycompany.com	f	f
99df64be-35cd-40dc-86b4-9986de7efd46	mike@mycompany.com	f	f
8f81d59a-316b-474f-b0fa-17187c2bdb39	elise@mycompany.com	f	f
ca8b5bc2-3fe4-463c-b310-757c0beb4f9e	aiden@mycompany.com	f	f
33c5f71d-c081-4c2b-bf5d-f241e4fd0adf	anna@mycompany.com	f	f
2f3d2d54-127f-4a4c-a549-f7d3c8bf82b6	callie@mycompany.com	f	f
126899fc-4a55-4443-a357-ef46289caaaa	heather@mycompany.com	f	f
d207e044-5fc0-4e1c-9b51-8ed29016ea11	jane@mycompany.com	f	f
f376ea78-41a8-4e3f-81d8-1931bc4f2455	ria@mycompany.com	f	f
50527384-d8c3-4f46-a4cf-75050039c452	ella@mycompany.com	f	f
95ef70fd-d6e2-4707-962e-bc694fdefe6b	halima@mycompany.com	f	f
c6ec5b3c-8762-48a6-a65a-7541647ce770	curtis@mycompany.com	f	f
5a93f20e-1b3b-402b-b18b-18d1d71f7109	luke@mycompany.com	f	f
748b2c22-1bae-4adc-8431-9b13e3e8b0d6	ellis@mycompany.com	f	f
f6cf1ea7-d581-4e6d-ac69-4560a7a14d01	owen@mycompany.com	f	f
5dac7755-5c0c-4295-9ff2-b5857d6fffbc	nicolas@mycompany.com	f	f
f655c851-07f2-4f3e-b354-d07196eabb67	fred@mycompany.com	f	f
\.


--
-- TOC entry 3442 (class 0 OID 78429)
-- Dependencies: 216
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee (id, created, firstname, jobtitle, lastname, mp_invalid, mp_number, notes, op_invalid, op_number, pa_city, pa_country, pa_postal_code, pa_state, pa_street, updated, department_id, primaryemail_id, reportsto_id, status_id) FROM stdin;
28fec399-d1a1-4237-9163-849c428b2236	2022-10-28 16:16:18.583799	Босс	умывальников начальник и мочалок командир	Большой	f	123450	очень солидный дядька	f	12345	Kyiv	Ukraine	03037	Kyiv	Azovska street, 12	\N	24b153c2-23e3-49c5-af8e-4b64ba33272b	8cb70af2-79e9-444a-949c-5ef85d00c327	\N	0d83c2a4-2806-4e51-8e25-9f4bea8e7542
158db891-2fa7-481f-984a-750cc1f656a0	2022-10-28 16:16:18.600339	Лох	умывальников работник и сортиров лучший друг	Большой	f	000999	лошара	f	000888	Kyiv	Ukraine	03037	Kyiv	Azovska street, 12	\N	24b153c2-23e3-49c5-af8e-4b64ba33272b	494756e8-be78-414d-9318-15519294efaa	28fec399-d1a1-4237-9163-849c428b2236	a497dd04-fc6d-4e9a-b2f5-0261cafdeacf
ceba59d8-51a4-44c7-8409-52c3979dca03	2022-10-28 16:16:18.621638	Adam	Cleaning services worker	Pakovski	f	0009992	Notes about Adam	f	0008881	Kyiv	Ukraine	03037	Kyiv	Azovska street, 12	\N	24b153c2-23e3-49c5-af8e-4b64ba33272b	f5e55934-f102-4fab-b643-57457887ec91	28fec399-d1a1-4237-9163-849c428b2236	0d83c2a4-2806-4e51-8e25-9f4bea8e7542
de02d7c2-b884-4bf9-9d97-a6850d7de1ee	2022-10-28 16:16:18.631415	Felix	переворачиватель пингвинов	Bimbo	f	0005552	:))	f	0007771	Kyiv	Ukraine	03037	Kyiv	Azovska street, 12	\N	1bf08199-d4d1-4a7c-abdf-0495f2603ba3	b7d96e48-73a9-4460-bc30-4b7125554b6f	28fec399-d1a1-4237-9163-849c428b2236	0d83c2a4-2806-4e51-8e25-9f4bea8e7542
efb1466c-f4ff-46e5-95e4-7e7c7531bb34	2022-10-28 16:16:18.640077	Raj	Designer	Kumar	f	74748347636	Praesent semper orci id mollis scelerisque. Quisque venenatis felis eu euismod tempor. Nunc orci magna, porta et risus et, tempor sollicitudin purus. In tempor lacinia tortor, ut porttitor enim convallis in. Sed et leo sagittis, maximus turpis vitae, posuere ligula. Fusce aliquam faucibus lacus eget accumsan. Mauris eget commodo nisl.	f	111333777	Kyiv	Ukraine	03037	Kyiv	Azovska street, 12	\N	21828f80-69c3-4a93-92f9-27496d84798a	1ab16634-2ee7-4d1b-b29b-ae096bb3e9b7	28fec399-d1a1-4237-9163-849c428b2236	a497dd04-fc6d-4e9a-b2f5-0261cafdeacf
3ee06767-aeba-4c7a-9948-eefa3fac2c87	2022-10-28 16:16:18.650185	Anton	Writer	Borodin	f	755686944	Praesent semper orci id mollis scelerisque.	f	844747475	Kyiv	Ukraine	03037	Kyiv	Azovska street, 13	\N	1bf08199-d4d1-4a7c-abdf-0495f2603ba3	6e544c06-7d6a-4b41-bfc9-c11e761b12e9	28fec399-d1a1-4237-9163-849c428b2236	a497dd04-fc6d-4e9a-b2f5-0261cafdeacf
479f4074-8f9e-4a8e-9467-5eb402e9a2e4	2022-10-28 16:16:18.660114	Joanna	Doctor	Smith	f	876654333	:)	f	1234567	Kyiv	Ukraine	03037	Kyiv	Azovska street, 15	\N	24b153c2-23e3-49c5-af8e-4b64ba33272b	a736905f-f39a-4952-ac4f-79803786f461	28fec399-d1a1-4237-9163-849c428b2236	0d83c2a4-2806-4e51-8e25-9f4bea8e7542
a3268ae8-0e31-422a-a0d4-a0f9ef20b6f1	2022-10-28 16:16:18.669838	Glenn	Worker	Wesson	f	876654333	:)	f	1234567	Kyiv	Ukraine	03037	Kyiv	Azovska street, 15	\N	24b153c2-23e3-49c5-af8e-4b64ba33272b	bbb0ba17-215f-4ebb-a33e-a11b01cbcc3c	28fec399-d1a1-4237-9163-849c428b2236	a497dd04-fc6d-4e9a-b2f5-0261cafdeacf
1efc3e7c-9fa2-4298-99ba-2377406ed18c	2022-10-28 16:16:18.67942	Hanna	Cook	Bergman	f	876654333	:)	f	1234567	Kyiv	Ukraine	03037	Kyiv	Azovska street, 15	\N	24b153c2-23e3-49c5-af8e-4b64ba33272b	40293784-fe05-445c-8bb3-9fcbaea59fe5	28fec399-d1a1-4237-9163-849c428b2236	0d83c2a4-2806-4e51-8e25-9f4bea8e7542
6b5781ed-c9e9-41b8-86bc-60dc137a9272	2022-10-28 16:16:18.687747	Mike	Painter	Brown	f	876654333	:)	f	1234567	Kyiv	Ukraine	03037	Kyiv	Azovska street, 15	\N	24b153c2-23e3-49c5-af8e-4b64ba33272b	99df64be-35cd-40dc-86b4-9986de7efd46	28fec399-d1a1-4237-9163-849c428b2236	0d83c2a4-2806-4e51-8e25-9f4bea8e7542
0b8cae5c-a291-4f07-8add-b16d5dfe863f	2022-10-28 16:16:18.696997	Elise	Worker	Mccann	f	876654333	:)	f	1234567	Kyiv	Ukraine	03037	Kyiv	Azovska street, 15	\N	24b153c2-23e3-49c5-af8e-4b64ba33272b	8f81d59a-316b-474f-b0fa-17187c2bdb39	28fec399-d1a1-4237-9163-849c428b2236	0d83c2a4-2806-4e51-8e25-9f4bea8e7542
83de846b-a61b-4bd0-bf1a-cb86f50ea3b4	2022-10-28 16:16:18.706052	Aiden	Worker	Berger	f	876654333	:)	f	1234567	Kyiv	Ukraine	03037	Kyiv	Azovska street, 15	\N	24b153c2-23e3-49c5-af8e-4b64ba33272b	ca8b5bc2-3fe4-463c-b310-757c0beb4f9e	28fec399-d1a1-4237-9163-849c428b2236	0d83c2a4-2806-4e51-8e25-9f4bea8e7542
466a34a4-74e8-4378-85c4-28c4bd1b9c0e	2022-10-28 16:16:18.715284	Anna	Worker	Chan	f	876654333	:)	f	1234567	Kyiv	Ukraine	03037	Kyiv	Azovska street, 15	\N	24b153c2-23e3-49c5-af8e-4b64ba33272b	33c5f71d-c081-4c2b-bf5d-f241e4fd0adf	28fec399-d1a1-4237-9163-849c428b2236	0d83c2a4-2806-4e51-8e25-9f4bea8e7542
8ce02555-0ae2-4858-89cc-50ecb1b09576	2022-10-28 16:16:18.725128	Callie	Worker	Krueger	f	876654333	:)	f	1234567	Kyiv	Ukraine	03037	Kyiv	Azovska street, 15	\N	24b153c2-23e3-49c5-af8e-4b64ba33272b	2f3d2d54-127f-4a4c-a549-f7d3c8bf82b6	28fec399-d1a1-4237-9163-849c428b2236	a497dd04-fc6d-4e9a-b2f5-0261cafdeacf
076ff61a-66a4-41f9-b497-99daeb26459a	2022-10-28 16:16:18.734058	Heather	Worker	Hutchinson	f	876654333	:)	f	1234567	Kyiv	Ukraine	03037	Kyiv	Azovska street, 15	\N	24b153c2-23e3-49c5-af8e-4b64ba33272b	126899fc-4a55-4443-a357-ef46289caaaa	28fec399-d1a1-4237-9163-849c428b2236	0d83c2a4-2806-4e51-8e25-9f4bea8e7542
36fa6eb0-5709-4ade-8657-d47d158a8058	2022-10-28 16:16:18.743234	Jane	Worker	Callahan	f	876654333	No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure.	f	1234567	Kyiv	Ukraine	03037	Kyiv	Azovska street, 15	\N	24b153c2-23e3-49c5-af8e-4b64ba33272b	d207e044-5fc0-4e1c-9b51-8ed29016ea11	28fec399-d1a1-4237-9163-849c428b2236	0d83c2a4-2806-4e51-8e25-9f4bea8e7542
99324c05-bb58-46e1-950c-61128905a6dd	2022-10-28 16:16:18.752726	Ria	Worker	Durham	f	876654333	:)	f	1234567	Kyiv	Ukraine	03037	Kyiv	Azovska street, 15	\N	24b153c2-23e3-49c5-af8e-4b64ba33272b	f376ea78-41a8-4e3f-81d8-1931bc4f2455	28fec399-d1a1-4237-9163-849c428b2236	0d83c2a4-2806-4e51-8e25-9f4bea8e7542
789adf18-aa60-4613-89ca-2d9743426b9b	2022-10-28 16:16:18.762272	Ella	Worker	Fields	f	876654333	:)	f	1234567	Kyiv	Ukraine	03037	Kyiv	Azovska street, 15	\N	24b153c2-23e3-49c5-af8e-4b64ba33272b	50527384-d8c3-4f46-a4cf-75050039c452	28fec399-d1a1-4237-9163-849c428b2236	a497dd04-fc6d-4e9a-b2f5-0261cafdeacf
6657a35c-863e-4375-85d2-1211283e54af	2022-10-28 16:16:18.770861	Halima	Worker	Hendricks	f	876654333	:)	f	1234567	Kyiv	Ukraine	03037	Kyiv	Azovska street, 15	\N	24b153c2-23e3-49c5-af8e-4b64ba33272b	95ef70fd-d6e2-4707-962e-bc694fdefe6b	28fec399-d1a1-4237-9163-849c428b2236	0d83c2a4-2806-4e51-8e25-9f4bea8e7542
ec4cd22f-e466-4681-903b-8b4bae1e2d24	2022-10-28 16:16:18.779037	Curtis	Worker	Andrews	f	876654333	:)	f	1234567	Kyiv	Ukraine	03037	Kyiv	Azovska street, 15	\N	24b153c2-23e3-49c5-af8e-4b64ba33272b	c6ec5b3c-8762-48a6-a65a-7541647ce770	28fec399-d1a1-4237-9163-849c428b2236	0d83c2a4-2806-4e51-8e25-9f4bea8e7542
9fb2709c-0504-4f0a-9c3f-90ee691c96ce	2022-10-28 16:16:18.788555	Luke	Worker	Barlow	f	876654333	:)	f	1234567	Kyiv	Ukraine	03037	Kyiv	Azovska street, 15	\N	24b153c2-23e3-49c5-af8e-4b64ba33272b	5a93f20e-1b3b-402b-b18b-18d1d71f7109	28fec399-d1a1-4237-9163-849c428b2236	0d83c2a4-2806-4e51-8e25-9f4bea8e7542
fa97dc7d-cf8e-4dff-86b2-2512b6c5a2e7	2022-10-28 16:16:18.798016	Ellis	Worker	Morrow	f	876654333	:)	f	1234567	Kyiv	Ukraine	03037	Kyiv	Azovska street, 15	\N	24b153c2-23e3-49c5-af8e-4b64ba33272b	748b2c22-1bae-4adc-8431-9b13e3e8b0d6	28fec399-d1a1-4237-9163-849c428b2236	0d83c2a4-2806-4e51-8e25-9f4bea8e7542
b08dd6b9-b743-4b9e-9bcb-fe1aadbffd2a	2022-10-28 16:16:18.807484	Owen	Worker	Frazier	f	876654333	:)	f	1234567	Kyiv	Ukraine	03037	Kyiv	Azovska street, 15	\N	24b153c2-23e3-49c5-af8e-4b64ba33272b	f6cf1ea7-d581-4e6d-ac69-4560a7a14d01	28fec399-d1a1-4237-9163-849c428b2236	a497dd04-fc6d-4e9a-b2f5-0261cafdeacf
c8033e11-ed4a-40be-b832-7bad63d35e8a	2022-10-28 16:16:18.81671	Nicolas	Worker	Reese	f	876654333	But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness.	f	1234567	Kyiv	Ukraine	03037	Kyiv	Azovska street, 15	\N	24b153c2-23e3-49c5-af8e-4b64ba33272b	5dac7755-5c0c-4295-9ff2-b5857d6fffbc	28fec399-d1a1-4237-9163-849c428b2236	0d83c2a4-2806-4e51-8e25-9f4bea8e7542
7682a482-d4a8-4ed1-b460-e53e9af19503	2022-10-28 16:16:18.826211	Fred	Worker	Mendoza	f	876654333	Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?	f	1234567	Kyiv	Ukraine	03037	Kyiv	Azovska street, 15	\N	24b153c2-23e3-49c5-af8e-4b64ba33272b	f655c851-07f2-4f3e-b354-d07196eabb67	28fec399-d1a1-4237-9163-849c428b2236	0d83c2a4-2806-4e51-8e25-9f4bea8e7542
\.


--
-- TOC entry 3443 (class 0 OID 78436)
-- Dependencies: 217
-- Data for Name: employee_emailaddress; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee_emailaddress (employee_id, alternateemails_id) FROM stdin;
158db891-2fa7-481f-984a-750cc1f656a0	c16727bd-c66f-4756-9490-2790d86969cb
158db891-2fa7-481f-984a-750cc1f656a0	30faa725-ca0c-4180-902f-48e7665e1ea4
158db891-2fa7-481f-984a-750cc1f656a0	5f2ce41f-ebff-41e8-affa-b8b3c0daf320
\.


--
-- TOC entry 3436 (class 0 OID 48211)
-- Dependencies: 210
-- Data for Name: employee_employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee_employee (employee_id, subordinates_id) FROM stdin;
\.


--
-- TOC entry 3444 (class 0 OID 78439)
-- Dependencies: 218
-- Data for Name: enumeration; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.enumeration (dtype, id, name) FROM stdin;
EmployeeStatus	0d83c2a4-2806-4e51-8e25-9f4bea8e7542	Active
EmployeeStatus	eaf8667a-1445-4906-a7bf-6350de324cf1	Dismissed
EmployeeStatus	a497dd04-fc6d-4e9a-b2f5-0261cafdeacf	On Leave
Department	24b153c2-23e3-49c5-af8e-4b64ba33272b	Department 1
Department	1bf08199-d4d1-4a7c-abdf-0495f2603ba3	Department 2
Department	21828f80-69c3-4a93-92f9-27496d84798a	Department 3
AccountType	cf6046c4-0c14-4d3d-beb9-6b96f1496758	Analyst
AccountType	9072b18b-e665-477e-a16c-cc833e77e364	Competitor
AccountType	57edc23c-b0a1-4032-9eec-3d2788f1e756	Customer
AccountType	bb09f5c6-3c9b-4871-b3fb-0b3103a18f83	Integrator
AccountType	e378c268-5be4-4f66-8057-bca998fd1fe0	Investor
AccountType	39d92beb-ddb5-41f3-ad7e-165f676edf0f	Partner
AccountType	21eaa407-320e-4783-8e04-dd78a58080b6	Press
AccountType	405fc3cd-bc4c-4151-aa26-cf6ba289d947	Prospect
AccountType	0cd8877d-ce70-4aa4-b49f-03524bd7f460	Reseller
AccountType	8826b8ee-462f-44cc-bdb9-686b8e927cdb	Other
LeadSource	9d492cf4-eac3-4f38-9307-5c2ab6328f51	Cold Call
LeadSource	1483ce94-ead5-43b8-a361-9c2fdfef589d	Existing Customer
LeadSource	128deab4-3967-460b-8320-b250cfac4ed1	Self Generated
LeadSource	05fc9cb5-8009-4ca7-b141-fc242b7f972b	Employee
LeadSource	8a30ba60-a684-4758-8c9e-fec1d00e60a4	Partner
LeadSource	0db00401-e17c-4c21-b33d-c116a4070270	Public Relations
LeadSource	01c69a5a-4e04-4368-a6f9-4a10897dfb80	Direct Mail
LeadSource	21c181d1-8b1f-4445-a10d-3c3ca5c21eaa	Conference
LeadSource	8050b1bc-d575-4eb4-9994-823ecf8eec1c	Trade Show
LeadSource	d2640266-390f-4e73-b698-0cafc56dbe07	Web Site
LeadSource	0060d3f1-5968-4e4f-8174-13b988612824	Word Of Mouth
LeadSource	afd8b8f1-74d7-4fca-a15a-017eb5ccaac9	Email
LeadSource	0a38299e-94d6-43f9-98da-f9423dd02bea	Campaign
LeadSource	cdb9396d-5096-4b3a-8571-eba1a61001f9	Other
OpportunityType	8625ed89-b12b-428c-8001-5b44c8fbf94c	Existing Business
OpportunityType	adfead4f-afe9-49bd-9163-e32e7ecb6bb8	New Business
LeadStatus	f7438ac9-16e5-4a34-8362-66d58c1b9d6d	New
LeadStatus	488ee168-03c7-42b2-a3f7-1c8e3939c9a5	Assigned
LeadStatus	4c78e121-1708-45f0-beb4-aaa346dec58b	In Process
LeadStatus	913a90c9-1046-4650-8e65-1548028e8ef8	Converted
LeadStatus	9099dea3-8f4b-45c3-91be-90aa8bc9f6fb	Recycled
LeadStatus	7befa959-abdc-4c3d-b788-34d7f1d4cbaa	Dead
Industry	935ea2a1-0e96-47d1-b263-816135ef20c2	Apparel
Industry	ac360a9d-cdc8-4037-9dec-3d7c5fa17705	Banking
Industry	b4b2f0b7-b83f-415e-bc98-63d20f94153b	Biotechnology
Industry	a57f6520-c2d3-4385-a7d2-3598b0254ea0	Chemicals
Industry	80e46539-36ab-457b-b426-2651b39ad2ac	Communications
Industry	a5b2bf33-254f-4155-9e09-48ee6c1d6814	Construction
Industry	988d37e3-6009-4223-93e0-dcb087862e33	Consulting
Industry	c6a6a3f8-a05f-435f-8765-108a2911689b	Education
Industry	f47427e6-acf5-4655-b6ee-2a8e8e98a14a	Electronics
Industry	d5300078-6640-4335-852e-d94cdb1a5cde	Energy
Industry	5c66754b-2b62-4ca1-95f7-058aeb0ba788	Engineering
Industry	88c3dc19-92e8-437b-8931-3c37b05fa2f7	Entertainment
Industry	44515b95-8681-4ddd-9cc3-d720458058c1	Environmental
Industry	b7f0db0d-f4f3-4160-9b09-9e13306c993e	Finance
Industry	155fae9a-bffd-4493-b4fa-a20ee7051c80	Government
Industry	2d78a19a-ae95-4933-a974-12b52a65aa33	Healthcare
Industry	1896e95d-b73b-4775-93f4-37c911089220	Hospitality
Industry	330aa136-c822-4069-adc8-33ea0b528693	Insurance
Industry	afa8975b-eac7-4a5e-8c31-16fa8ea381e3	Machinery
Industry	de5bc188-bf2f-47c2-b499-d62468d22da3	Manufacturing
Industry	89518bbb-c3ae-451c-b7e0-a9ea25603eec	Media
Industry	4fa92151-852e-4112-aecf-cb07693b7932	Not For Profit
Industry	e734ae50-637b-4dde-b03b-a32b7b9bd5bc	Recreation
Industry	340a7dcb-e7f5-44f1-be8c-130206ecfe11	Retail
Industry	ecf2f2a5-c122-41ab-82fe-14df000b87e9	Shipping
Industry	0c511842-cdb4-440f-a51a-b1f9d12dfc2e	Technology
Industry	16acfde1-e881-4a24-979f-c441c3308c33	Telecommunications
Industry	a7d7b112-b348-42a5-b717-c6aa0ef05378	Transportation
Industry	b413c91d-aee6-49bd-8bf1-727ddde30c70	Utilities
Industry	ce8b0ffd-9ff5-4189-b743-20646a9eaa2d	Other
SalesStage	9e8baa18-477f-48ca-84d4-c3c388c42d21	Prospecting
SalesStage	b5a30a26-4072-425a-9738-c396f3b98d14	Qualification
SalesStage	f64fa2ae-4479-41f7-89e6-56ded5ffd8be	Needs Analysis
SalesStage	b3c307b0-407b-4349-9288-3dbb61164130	Value Proposition
SalesStage	92fbdc4b-ac6a-4716-a42b-54796587000f	Identifying Decision Makers
SalesStage	536496bf-a1a9-4f67-91f0-5a19700d9857	Perception Analysis
SalesStage	57f711f8-e16f-4893-acc9-77ea82090349	Proposal/Price Quote
SalesStage	e768fab5-ba09-42b4-be7a-43860ab7b16d	Negotiation/Review
SalesStage	8448c42e-6d69-4017-9590-5054a7d47d93	Closed Won
SalesStage	eb8397bf-b22b-45ad-99aa-1fde8ffd11fb	Closed Lost
\.


--
-- TOC entry 3445 (class 0 OID 78444)
-- Dependencies: 219
-- Data for Name: individual; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.individual (dtype, id, createdat, department, description, firstname, jobtitle, lastname, updatedat, assistantname, birthday, opportunityamount, account_id, alternateaddress_id, assignedto_id, leadsource_id, mobilephone_id, officephone_id, primaryaddress_id, primaryemail_id, assistantphone_id, reportsto_id, status_id) FROM stdin;
\.


--
-- TOC entry 3446 (class 0 OID 78451)
-- Dependencies: 220
-- Data for Name: individual_emailaddress; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.individual_emailaddress (individual_id, alternateemails_id) FROM stdin;
\.


--
-- TOC entry 3447 (class 0 OID 78454)
-- Dependencies: 221
-- Data for Name: opportunity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.opportunity (id, amount, description, expectedclosedate, name, nextstep, probability, account_id, assignedto_id, leadsource_id, salesstage_id, type_id) FROM stdin;
\.


--
-- TOC entry 3448 (class 0 OID 78461)
-- Dependencies: 222
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.role (id, name) FROM stdin;
12b1f29a-9eca-47e6-a945-5cbe00bfb87f	user
2da4d455-f5ce-4dbb-9042-98e9eb2d9d3e	manager
2718f02d-bd6f-4914-8962-152b32c353cb	admin
\.


--
-- TOC entry 3449 (class 0 OID 78466)
-- Dependencies: 223
-- Data for Name: security_users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.security_users (id, name, password, username) FROM stdin;
3f65079e-3d45-4420-8c7a-5bf448d910b8	User 1	$2a$10$XH0ODcA0hGK9cU5CeobI9.46DhaBU01Ai0lSA.WlgO3tzI4SMs.uO	user1
2a5fe239-a51b-4f00-af96-f289ad021321	Manager 1	$2a$10$iAN7X6HFRzYGSotcrgwNOe9mtUvBu0tjgYDkGYehQ12SmsHCY9tkK	manager1
42eab7ab-0a1d-4cf2-902a-a6538cee50ca	Admin 1	$2a$10$Z1tpIQuGutEnulF4xNE/KePmCfZJsJXxq9GoodEW5JT4APMIHy/5G	admin1
\.


--
-- TOC entry 3450 (class 0 OID 78473)
-- Dependencies: 224
-- Data for Name: security_users_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.security_users_role (user_id, roles_id) FROM stdin;
3f65079e-3d45-4420-8c7a-5bf448d910b8	12b1f29a-9eca-47e6-a945-5cbe00bfb87f
2a5fe239-a51b-4f00-af96-f289ad021321	12b1f29a-9eca-47e6-a945-5cbe00bfb87f
2a5fe239-a51b-4f00-af96-f289ad021321	2da4d455-f5ce-4dbb-9042-98e9eb2d9d3e
42eab7ab-0a1d-4cf2-902a-a6538cee50ca	12b1f29a-9eca-47e6-a945-5cbe00bfb87f
42eab7ab-0a1d-4cf2-902a-a6538cee50ca	2da4d455-f5ce-4dbb-9042-98e9eb2d9d3e
42eab7ab-0a1d-4cf2-902a-a6538cee50ca	2718f02d-bd6f-4914-8962-152b32c353cb
\.


--
-- TOC entry 3451 (class 0 OID 78476)
-- Dependencies: 225
-- Data for Name: telephonenumber; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.telephonenumber (id, invalid, number) FROM stdin;
\.


--
-- TOC entry 3458 (class 0 OID 0)
-- Dependencies: 209
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, true);


--
-- TOC entry 3232 (class 2606 OID 78410)
-- Name: account account_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (id);


--
-- TOC entry 3238 (class 2606 OID 78423)
-- Name: address address_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.address
    ADD CONSTRAINT address_pkey PRIMARY KEY (id);


--
-- TOC entry 3240 (class 2606 OID 78428)
-- Name: emailaddress emailaddress_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emailaddress
    ADD CONSTRAINT emailaddress_pkey PRIMARY KEY (id);


--
-- TOC entry 3228 (class 2606 OID 48215)
-- Name: employee_employee employee_employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_employee
    ADD CONSTRAINT employee_employee_pkey PRIMARY KEY (employee_id, subordinates_id);


--
-- TOC entry 3242 (class 2606 OID 78435)
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);


--
-- TOC entry 3246 (class 2606 OID 78443)
-- Name: enumeration enumeration_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enumeration
    ADD CONSTRAINT enumeration_pkey PRIMARY KEY (id);


--
-- TOC entry 3248 (class 2606 OID 78450)
-- Name: individual individual_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.individual
    ADD CONSTRAINT individual_pkey PRIMARY KEY (id);


--
-- TOC entry 3252 (class 2606 OID 78460)
-- Name: opportunity opportunity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.opportunity
    ADD CONSTRAINT opportunity_pkey PRIMARY KEY (id);


--
-- TOC entry 3254 (class 2606 OID 78465)
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- TOC entry 3256 (class 2606 OID 78472)
-- Name: security_users security_users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.security_users
    ADD CONSTRAINT security_users_pkey PRIMARY KEY (id);


--
-- TOC entry 3258 (class 2606 OID 78480)
-- Name: telephonenumber telephonenumber_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.telephonenumber
    ADD CONSTRAINT telephonenumber_pkey PRIMARY KEY (id);


--
-- TOC entry 3244 (class 2606 OID 78486)
-- Name: employee_emailaddress uk_4t3j0umeqpn2gkjiq7w98idb1; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_emailaddress
    ADD CONSTRAINT uk_4t3j0umeqpn2gkjiq7w98idb1 UNIQUE (alternateemails_id);


--
-- TOC entry 3236 (class 2606 OID 78484)
-- Name: account_individual uk_fw3cb0apr9rhpuygnrtclibh0; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account_individual
    ADD CONSTRAINT uk_fw3cb0apr9rhpuygnrtclibh0 UNIQUE (contacts_id);


--
-- TOC entry 3234 (class 2606 OID 78482)
-- Name: account_emailaddress uk_g588rnp0871e9sbd4jyb8i1rq; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account_emailaddress
    ADD CONSTRAINT uk_g588rnp0871e9sbd4jyb8i1rq UNIQUE (alternateemails_id);


--
-- TOC entry 3250 (class 2606 OID 78488)
-- Name: individual_emailaddress uk_i7uvo7u14aubfymp2m2k727ns; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.individual_emailaddress
    ADD CONSTRAINT uk_i7uvo7u14aubfymp2m2k727ns UNIQUE (alternateemails_id);


--
-- TOC entry 3230 (class 2606 OID 48252)
-- Name: employee_employee uk_qyu5b6rj2oc7a0lj6grmyqqbe; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_employee
    ADD CONSTRAINT uk_qyu5b6rj2oc7a0lj6grmyqqbe UNIQUE (subordinates_id);


--
-- TOC entry 3294 (class 2606 OID 78664)
-- Name: security_users_role fk2hsgb2g7w3d03elp609s9k4vp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.security_users_role
    ADD CONSTRAINT fk2hsgb2g7w3d03elp609s9k4vp FOREIGN KEY (roles_id) REFERENCES public.role(id);


--
-- TOC entry 3276 (class 2606 OID 78604)
-- Name: individual fk2iuv97jxwb517sy0r1a9yebgr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.individual
    ADD CONSTRAINT fk2iuv97jxwb517sy0r1a9yebgr FOREIGN KEY (primaryaddress_id) REFERENCES public.address(id);


--
-- TOC entry 3289 (class 2606 OID 78639)
-- Name: opportunity fk2p376f1su32a7sxqnjpur4h3p; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.opportunity
    ADD CONSTRAINT fk2p376f1su32a7sxqnjpur4h3p FOREIGN KEY (account_id) REFERENCES public.account(id);


--
-- TOC entry 3266 (class 2606 OID 78524)
-- Name: account_emailaddress fk3ua8t6b8an0tdo2t5vevivh96; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account_emailaddress
    ADD CONSTRAINT fk3ua8t6b8an0tdo2t5vevivh96 FOREIGN KEY (alternateemails_id) REFERENCES public.emailaddress(id);


--
-- TOC entry 3277 (class 2606 OID 78614)
-- Name: individual fk3v3wewji4r8xby3bvwu324hr9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.individual
    ADD CONSTRAINT fk3v3wewji4r8xby3bvwu324hr9 FOREIGN KEY (assistantphone_id) REFERENCES public.telephonenumber(id);


--
-- TOC entry 3270 (class 2606 OID 78549)
-- Name: employee fk41jd3mkwk1hyhopvdgnhwm6xj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT fk41jd3mkwk1hyhopvdgnhwm6xj FOREIGN KEY (primaryemail_id) REFERENCES public.emailaddress(id);


--
-- TOC entry 3295 (class 2606 OID 78669)
-- Name: security_users_role fk5d3j4mqhoq5jljak5c8rewapa; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.security_users_role
    ADD CONSTRAINT fk5d3j4mqhoq5jljak5c8rewapa FOREIGN KEY (user_id) REFERENCES public.security_users(id);


--
-- TOC entry 3259 (class 2606 OID 78489)
-- Name: account fk7xru07gjng8ypt6tn9cyjpgjc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT fk7xru07gjng8ypt6tn9cyjpgjc FOREIGN KEY (assignedto_id) REFERENCES public.employee(id);


--
-- TOC entry 3287 (class 2606 OID 78629)
-- Name: individual_emailaddress fk8t6q8xokf8gvgd2l1ix6wj2lc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.individual_emailaddress
    ADD CONSTRAINT fk8t6q8xokf8gvgd2l1ix6wj2lc FOREIGN KEY (alternateemails_id) REFERENCES public.emailaddress(id);


--
-- TOC entry 3290 (class 2606 OID 78654)
-- Name: opportunity fk9ay6aqmjch28cxj2wtk9idli2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.opportunity
    ADD CONSTRAINT fk9ay6aqmjch28cxj2wtk9idli2 FOREIGN KEY (salesstage_id) REFERENCES public.enumeration(id);


--
-- TOC entry 3278 (class 2606 OID 78609)
-- Name: individual fkaabhs8mhc9ctrlrujor3be6g7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.individual
    ADD CONSTRAINT fkaabhs8mhc9ctrlrujor3be6g7 FOREIGN KEY (primaryemail_id) REFERENCES public.emailaddress(id);


--
-- TOC entry 3271 (class 2606 OID 78544)
-- Name: employee fkavfvdbfr4dv0849d4a9uoy20s; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT fkavfvdbfr4dv0849d4a9uoy20s FOREIGN KEY (department_id) REFERENCES public.enumeration(id);


--
-- TOC entry 3279 (class 2606 OID 78599)
-- Name: individual fkb06rcpguslxkdji5kjneu2ji4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.individual
    ADD CONSTRAINT fkb06rcpguslxkdji5kjneu2ji4 FOREIGN KEY (officephone_id) REFERENCES public.telephonenumber(id);


--
-- TOC entry 3280 (class 2606 OID 78619)
-- Name: individual fkb4slsyuh6wphbn8fusnjehyoc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.individual
    ADD CONSTRAINT fkb4slsyuh6wphbn8fusnjehyoc FOREIGN KEY (reportsto_id) REFERENCES public.individual(id);


--
-- TOC entry 3291 (class 2606 OID 78644)
-- Name: opportunity fkbph2u7y9vd08hih0u8l05rjac; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.opportunity
    ADD CONSTRAINT fkbph2u7y9vd08hih0u8l05rjac FOREIGN KEY (assignedto_id) REFERENCES public.employee(id);


--
-- TOC entry 3260 (class 2606 OID 78509)
-- Name: account fkc0ogxh2m4i9r41okhf6qye0c3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT fkc0ogxh2m4i9r41okhf6qye0c3 FOREIGN KEY (primaryemail_id) REFERENCES public.emailaddress(id);


--
-- TOC entry 3274 (class 2606 OID 78569)
-- Name: employee_emailaddress fkcm4b9idokfvq9j9jewyvgglym; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_emailaddress
    ADD CONSTRAINT fkcm4b9idokfvq9j9jewyvgglym FOREIGN KEY (employee_id) REFERENCES public.employee(id);


--
-- TOC entry 3261 (class 2606 OID 78504)
-- Name: account fkda0hbrqb5tgrh0mnvo2d7kcks; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT fkda0hbrqb5tgrh0mnvo2d7kcks FOREIGN KEY (officephone_id) REFERENCES public.telephonenumber(id);


--
-- TOC entry 3281 (class 2606 OID 78594)
-- Name: individual fkdhpp7kge6is9fgqglxmed8orf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.individual
    ADD CONSTRAINT fkdhpp7kge6is9fgqglxmed8orf FOREIGN KEY (mobilephone_id) REFERENCES public.telephonenumber(id);


--
-- TOC entry 3262 (class 2606 OID 78514)
-- Name: account fkdxr6fh1fpnb59nrws4ide1fct; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT fkdxr6fh1fpnb59nrws4ide1fct FOREIGN KEY (shippingaddress_id) REFERENCES public.address(id);


--
-- TOC entry 3292 (class 2606 OID 78659)
-- Name: opportunity fkg13saefoeaiy47jneyrkpgtcm; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.opportunity
    ADD CONSTRAINT fkg13saefoeaiy47jneyrkpgtcm FOREIGN KEY (type_id) REFERENCES public.enumeration(id);


--
-- TOC entry 3263 (class 2606 OID 78499)
-- Name: account fkg3t2lfprt0qy54xkqlaro81hx; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT fkg3t2lfprt0qy54xkqlaro81hx FOREIGN KEY (industry_id) REFERENCES public.enumeration(id);


--
-- TOC entry 3268 (class 2606 OID 78539)
-- Name: account_individual fkg8si6brp559637i99tkdnym6r; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account_individual
    ADD CONSTRAINT fkg8si6brp559637i99tkdnym6r FOREIGN KEY (account_id) REFERENCES public.account(id);


--
-- TOC entry 3282 (class 2606 OID 78589)
-- Name: individual fkgejmngdlgd8rejv5umnkarqa9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.individual
    ADD CONSTRAINT fkgejmngdlgd8rejv5umnkarqa9 FOREIGN KEY (leadsource_id) REFERENCES public.enumeration(id);


--
-- TOC entry 3293 (class 2606 OID 78649)
-- Name: opportunity fkh062v1krlxt2i796q71awp13n; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.opportunity
    ADD CONSTRAINT fkh062v1krlxt2i796q71awp13n FOREIGN KEY (leadsource_id) REFERENCES public.enumeration(id);


--
-- TOC entry 3288 (class 2606 OID 78634)
-- Name: individual_emailaddress fkhextmd8dcp01pl3x486qswkq0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.individual_emailaddress
    ADD CONSTRAINT fkhextmd8dcp01pl3x486qswkq0 FOREIGN KEY (individual_id) REFERENCES public.individual(id);


--
-- TOC entry 3283 (class 2606 OID 78624)
-- Name: individual fkjl2gg7oqu1kj2ywmljesapolc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.individual
    ADD CONSTRAINT fkjl2gg7oqu1kj2ywmljesapolc FOREIGN KEY (status_id) REFERENCES public.enumeration(id);


--
-- TOC entry 3269 (class 2606 OID 78534)
-- Name: account_individual fkk22bbinjbvv0yj2uhyg1glegb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account_individual
    ADD CONSTRAINT fkk22bbinjbvv0yj2uhyg1glegb FOREIGN KEY (contacts_id) REFERENCES public.individual(id);


--
-- TOC entry 3275 (class 2606 OID 78564)
-- Name: employee_emailaddress fkk63v9uaf9btcu5xlcc3nj0546; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_emailaddress
    ADD CONSTRAINT fkk63v9uaf9btcu5xlcc3nj0546 FOREIGN KEY (alternateemails_id) REFERENCES public.emailaddress(id);


--
-- TOC entry 3264 (class 2606 OID 78494)
-- Name: account fkkj6efeuh4lienbn9qrsgt10gp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT fkkj6efeuh4lienbn9qrsgt10gp FOREIGN KEY (billingaddress_id) REFERENCES public.address(id);


--
-- TOC entry 3284 (class 2606 OID 78574)
-- Name: individual fkku850aehy86gptytdncampe3p; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.individual
    ADD CONSTRAINT fkku850aehy86gptytdncampe3p FOREIGN KEY (account_id) REFERENCES public.account(id);


--
-- TOC entry 3285 (class 2606 OID 78584)
-- Name: individual fkmeugnat72m2sn91m6g6uw1xwc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.individual
    ADD CONSTRAINT fkmeugnat72m2sn91m6g6uw1xwc FOREIGN KEY (assignedto_id) REFERENCES public.employee(id);


--
-- TOC entry 3272 (class 2606 OID 78559)
-- Name: employee fkmr2tvgdoqh775ix0a0uoeqrt6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT fkmr2tvgdoqh775ix0a0uoeqrt6 FOREIGN KEY (status_id) REFERENCES public.enumeration(id);


--
-- TOC entry 3273 (class 2606 OID 78554)
-- Name: employee fkn2leumfv4nhn60r4949c0gigd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT fkn2leumfv4nhn60r4949c0gigd FOREIGN KEY (reportsto_id) REFERENCES public.employee(id);


--
-- TOC entry 3286 (class 2606 OID 78579)
-- Name: individual fkn618kaflpm744jrki4mv8085u; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.individual
    ADD CONSTRAINT fkn618kaflpm744jrki4mv8085u FOREIGN KEY (alternateaddress_id) REFERENCES public.address(id);


--
-- TOC entry 3267 (class 2606 OID 78529)
-- Name: account_emailaddress fknxo604lvwf1hqasi63n5keln9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account_emailaddress
    ADD CONSTRAINT fknxo604lvwf1hqasi63n5keln9 FOREIGN KEY (account_id) REFERENCES public.account(id);


--
-- TOC entry 3265 (class 2606 OID 78519)
-- Name: account fkqnre703cv4iqphuibesgxko97; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT fkqnre703cv4iqphuibesgxko97 FOREIGN KEY (type_id) REFERENCES public.enumeration(id);


-- Completed on 2022-10-28 13:17:23 UTC

--
-- PostgreSQL database dump complete
--

