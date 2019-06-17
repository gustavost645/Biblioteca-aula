--
-- PostgreSQL database dump
--

-- Dumped from database version 10.4
-- Dumped by pg_dump version 10.4


-
-- usuario e senha do admnistrador do sistema "demo" e "demo"
-- usuario e senha do usuario do sistema "user" e "1234"
--


SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- Name: fupcodbarraslivro(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.fupcodbarraslivro() RETURNS trigger
    LANGUAGE plpgsql
    AS $$BEGIN
UPDATE livro 
SET codBarras=(SELECT lpad(cast(id as varchar),13,'0')  as cod 
			   FROM livro 
			   WHERE id=new.id) 
WHERE id=new.id;
RETURN NULL;
END;
$$;


ALTER FUNCTION public.fupcodbarraslivro() OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: assunto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.assunto (
    id integer NOT NULL,
    descricao text
);


ALTER TABLE public.assunto OWNER TO postgres;

--
-- Name: assunto_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.assunto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.assunto_id_seq OWNER TO postgres;

--
-- Name: assunto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.assunto_id_seq OWNED BY public.assunto.id;


--
-- Name: autor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.autor (
    id integer NOT NULL,
    nome text
);


ALTER TABLE public.autor OWNER TO postgres;

--
-- Name: autor_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.autor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.autor_id_seq OWNER TO postgres;

--
-- Name: autor_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.autor_id_seq OWNED BY public.autor.id;


--
-- Name: cidade; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cidade (
    id integer NOT NULL,
    nome text,
    uf character varying(2)
);


ALTER TABLE public.cidade OWNER TO postgres;

--
-- Name: cidade_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cidade_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cidade_id_seq OWNER TO postgres;

--
-- Name: cidade_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cidade_id_seq OWNED BY public.cidade.id;


--
-- Name: class_literaria; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.class_literaria (
    id integer NOT NULL,
    descricao text
);


ALTER TABLE public.class_literaria OWNER TO postgres;

--
-- Name: class_literaria_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.class_literaria_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.class_literaria_id_seq OWNER TO postgres;

--
-- Name: class_literaria_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.class_literaria_id_seq OWNED BY public.class_literaria.id;


--
-- Name: colecao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.colecao (
    id integer NOT NULL,
    descricao text
);


ALTER TABLE public.colecao OWNER TO postgres;

--
-- Name: colecao_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.colecao_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.colecao_id_seq OWNER TO postgres;

--
-- Name: colecao_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.colecao_id_seq OWNED BY public.colecao.id;


--
-- Name: editora; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.editora (
    id integer NOT NULL,
    descricao text
);


ALTER TABLE public.editora OWNER TO postgres;

--
-- Name: editora_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.editora_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.editora_id_seq OWNER TO postgres;

--
-- Name: editora_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.editora_id_seq OWNED BY public.editora.id;


--
-- Name: emprestimo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.emprestimo (
    id integer NOT NULL,
    id_livro integer NOT NULL,
    dataemprestimo date NOT NULL,
    datavencimento date NOT NULL,
    datachegada date,
    id_leitor integer
);


ALTER TABLE public.emprestimo OWNER TO postgres;

--
-- Name: emprestimo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.emprestimo_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.emprestimo_id_seq OWNER TO postgres;

--
-- Name: emprestimo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.emprestimo_id_seq OWNED BY public.emprestimo.id;


--
-- Name: leitor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.leitor (
    id integer NOT NULL,
    nome text NOT NULL,
    endereco character varying(150),
    cidade_id integer NOT NULL,
    tipo integer NOT NULL,
    dt_nascimento date,
    matricula character varying(45),
    turma character varying(45),
    turno character varying(45),
    limite_livros character varying(10),
    status character varying(1),
    del character varying(1),
    num_cgc character(14) NOT NULL,
    email character varying(200),
    data_registro date
);


ALTER TABLE public.leitor OWNER TO postgres;

--
-- Name: leitor_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.leitor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.leitor_id_seq OWNER TO postgres;

--
-- Name: leitor_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.leitor_id_seq OWNED BY public.leitor.id;


--
-- Name: livro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.livro (
    id integer NOT NULL,
    titulo text,
    subtitulo text,
    isbn text,
    volume integer,
    anoedicao integer,
    edicao integer,
    tombo text,
    cdu text,
    cdd text,
    cutter text,
    id_editora integer,
    id_class_literaria integer,
    id_colecao integer,
    data_aquisicao date,
    status character varying(1),
    del character varying(1),
    codbarras character varying(13)
);


ALTER TABLE public.livro OWNER TO postgres;

--
-- Name: livro_assunto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.livro_assunto (
    id integer NOT NULL,
    id_livro integer,
    id_assunto integer
);


ALTER TABLE public.livro_assunto OWNER TO postgres;

--
-- Name: livro_assunto_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.livro_assunto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.livro_assunto_id_seq OWNER TO postgres;

--
-- Name: livro_assunto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.livro_assunto_id_seq OWNED BY public.livro_assunto.id;


--
-- Name: livro_autor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.livro_autor (
    id integer NOT NULL,
    id_livro integer,
    id_autor integer
);


ALTER TABLE public.livro_autor OWNER TO postgres;

--
-- Name: livro_autor_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.livro_autor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.livro_autor_id_seq OWNER TO postgres;

--
-- Name: livro_autor_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.livro_autor_id_seq OWNED BY public.livro_autor.id;


--
-- Name: livro_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.livro_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.livro_id_seq OWNER TO postgres;

--
-- Name: livro_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.livro_id_seq OWNED BY public.livro.id;


--
-- Name: login; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.login (
    id integer NOT NULL,
    nome text,
    login character varying(45),
    password character varying(45),
    status character varying(1),
    del character varying(1),
    role character varying(1)
);


ALTER TABLE public.login OWNER TO postgres;

--
-- Name: login_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.login_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.login_id_seq OWNER TO postgres;

--
-- Name: login_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.login_id_seq OWNED BY public.login.id;


--
-- Name: assunto id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.assunto ALTER COLUMN id SET DEFAULT nextval('public.assunto_id_seq'::regclass);


--
-- Name: autor id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autor ALTER COLUMN id SET DEFAULT nextval('public.autor_id_seq'::regclass);


--
-- Name: cidade id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cidade ALTER COLUMN id SET DEFAULT nextval('public.cidade_id_seq'::regclass);


--
-- Name: class_literaria id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.class_literaria ALTER COLUMN id SET DEFAULT nextval('public.class_literaria_id_seq'::regclass);


--
-- Name: colecao id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.colecao ALTER COLUMN id SET DEFAULT nextval('public.colecao_id_seq'::regclass);


--
-- Name: editora id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.editora ALTER COLUMN id SET DEFAULT nextval('public.editora_id_seq'::regclass);


--
-- Name: emprestimo id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emprestimo ALTER COLUMN id SET DEFAULT nextval('public.emprestimo_id_seq'::regclass);


--
-- Name: leitor id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leitor ALTER COLUMN id SET DEFAULT nextval('public.leitor_id_seq'::regclass);


--
-- Name: livro id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro ALTER COLUMN id SET DEFAULT nextval('public.livro_id_seq'::regclass);


--
-- Name: livro_assunto id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro_assunto ALTER COLUMN id SET DEFAULT nextval('public.livro_assunto_id_seq'::regclass);


--
-- Name: livro_autor id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro_autor ALTER COLUMN id SET DEFAULT nextval('public.livro_autor_id_seq'::regclass);


--
-- Name: login id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.login ALTER COLUMN id SET DEFAULT nextval('public.login_id_seq'::regclass);


--
-- Data for Name: assunto; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.assunto VALUES (1, 'JAVA');
INSERT INTO public.assunto VALUES (2, 'PHP');
INSERT INTO public.assunto VALUES (3, 'JAVASCRITP');
INSERT INTO public.assunto VALUES (4, 'DELPHI');
INSERT INTO public.assunto VALUES (5, 'ANGULAR6');


--
-- Data for Name: autor; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.autor VALUES (1, 'GUSTAVO');
INSERT INTO public.autor VALUES (2, 'JONATAN');
INSERT INTO public.autor VALUES (3, 'BERNARDO');


--
-- Data for Name: cidade; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cidade VALUES (1, 'LAJEADO', 'RS');


--
-- Data for Name: class_literaria; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.class_literaria VALUES (1, 'TESTE UM');
INSERT INTO public.class_literaria VALUES (2, 'TESTE DOIS');
INSERT INTO public.class_literaria VALUES (3, 'TESTE TRES');


--
-- Data for Name: colecao; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.colecao VALUES (1, 'LIVROS');
INSERT INTO public.colecao VALUES (2, 'REVISTAS');


--
-- Data for Name: editora; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.editora VALUES (1, 'ADIANTI SOLUTIONS');
INSERT INTO public.editora VALUES (2, 'GS SOFTWARES');
INSERT INTO public.editora VALUES (3, 'É  DE CASA');


--
-- Data for Name: emprestimo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.emprestimo VALUES (7, 2, '2019-05-26', '2019-06-03', '2019-05-26', 3);
INSERT INTO public.emprestimo VALUES (14, 16, '2019-05-27', '2019-06-03', '2019-05-27', 3);
INSERT INTO public.emprestimo VALUES (9, 8, '2019-05-27', '2019-06-03', '2019-05-27', 4);
INSERT INTO public.emprestimo VALUES (8, 2, '2019-05-27', '2019-06-03', '2019-05-27', 4);
INSERT INTO public.emprestimo VALUES (16, 16, '2019-05-27', '2019-06-03', '2019-05-27', 8);
INSERT INTO public.emprestimo VALUES (17, 15, '2019-05-27', '2019-06-03', '2019-05-27', 8);
INSERT INTO public.emprestimo VALUES (21, 20, '2019-05-27', '2019-06-03', '2019-05-27', 9);
INSERT INTO public.emprestimo VALUES (18, 22, '2019-05-27', '2019-06-03', '2019-05-27', 8);
INSERT INTO public.emprestimo VALUES (11, 9, '2019-03-29', '2019-04-30', '2019-05-27', 9);
INSERT INTO public.emprestimo VALUES (12, 11, '2019-05-27', '2019-06-03', '2019-05-27', 4);
INSERT INTO public.emprestimo VALUES (15, 10, '2019-05-27', '2019-06-03', '2019-05-27', 8);
INSERT INTO public.emprestimo VALUES (20, 13, '2019-05-27', '2019-06-03', '2019-05-27', 8);
INSERT INTO public.emprestimo VALUES (13, 14, '2019-05-27', '2019-06-03', '2019-05-27', 4);
INSERT INTO public.emprestimo VALUES (22, 24, '2019-05-27', '2019-06-03', '2019-05-27', 8);
INSERT INTO public.emprestimo VALUES (24, 13, '2019-05-27', '2019-06-03', '2019-05-27', 3);
INSERT INTO public.emprestimo VALUES (25, 14, '2019-05-27', '2019-06-03', '2019-05-27', 3);
INSERT INTO public.emprestimo VALUES (26, 15, '2019-05-27', '2019-06-03', '2019-05-27', 3);
INSERT INTO public.emprestimo VALUES (27, 16, '2019-05-27', '2019-06-03', '2019-05-27', 3);
INSERT INTO public.emprestimo VALUES (28, 17, '2019-05-27', '2019-06-03', '2019-05-27', 3);
INSERT INTO public.emprestimo VALUES (23, 12, '2019-05-27', '2019-06-03', '2019-05-27', 3);
INSERT INTO public.emprestimo VALUES (29, 11, '2019-05-27', '2019-06-03', NULL, 3);
INSERT INTO public.emprestimo VALUES (31, 15, '2019-05-27', '2019-06-03', NULL, 3);
INSERT INTO public.emprestimo VALUES (32, 21, '2019-05-27', '2019-06-03', NULL, 3);
INSERT INTO public.emprestimo VALUES (33, 22, '2019-05-27', '2019-06-03', NULL, 3);
INSERT INTO public.emprestimo VALUES (30, 13, '2019-05-27', '2019-06-03', '2019-05-27', 3);


--
-- Data for Name: leitor; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.leitor VALUES (2, 'Gustavo Steinhoefel', 'teste', 1, 0, '2019-05-20', '1', '1', 'Manhã', '5', '0', '1', '83502254087   ', NULL, NULL);
INSERT INTO public.leitor VALUES (5, 'a', '', 1, 0, '2019-05-21', '', '', 'Manhã', '5', '0', '1', '11111111111   ', '', '2019-05-21');
INSERT INTO public.leitor VALUES (6, 'a', '', 1, 0, '2019-05-21', '', '', 'Manhã', '5', '0', '1', '11111111111   ', '', '2019-05-21');
INSERT INTO public.leitor VALUES (7, 'dirléia da silva steinhoefel', 'av cristiano dexheimer n95, campestre', 1, 0, '1989-08-04', '', '', 'Manhã', '5', '0', '1', '02234343444   ', 'dirleia89@gmail.com', '2019-05-21');
INSERT INTO public.leitor VALUES (3, 'Bernardo Steinhoefel', 'teste', 1, 0, '2019-05-03', '123', '512', 'Manhã', '5', '0', '0', '46448038205   ', 'bernardo.steinhoefel@gmail.com', '2019-05-26');
INSERT INTO public.leitor VALUES (4, 'Gustavo Steinhoefel', 'av cristiano dexheimer, n95 campestre', 1, 0, '1989-06-10', '', '512', 'Manhã', '5', '0', '0', '83502254087   ', 'gustavost_645@hotmail.com', '2019-05-26');
INSERT INTO public.leitor VALUES (9, 'Nair Steinhoefel', 'serafim costa n 43, campestre', 1, 0, '1968-10-13', '', '511', 'Manhã', '5', '0', '0', '99548948028   ', '', '2019-05-27');
INSERT INTO public.leitor VALUES (8, 'Dirleia da Silva Steinhoefel', 'av crisitano dexheimer n95, campestre', 1, 2, '1989-08-04', '', '511', 'Manhã', '5', '0', '0', '88214799007   ', 'dirleia89@gmail.com', '2019-05-27');
INSERT INTO public.leitor VALUES (10, 'Soraia Steinhoefel', 'serafim costa n43, campestre', 1, 0, '1978-10-20', '', '510', 'Manhã', '5', '0', '0', '83776453001   ', '', '2019-05-27');


--
-- Data for Name: livro; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.livro VALUES (2, 'java', 'java', '12345678', 1, 2019, 1, '', '', '', '', 2, 2, 1, '2019-05-20', '0', '0', '0000000000002');
INSERT INTO public.livro VALUES (20, 'pequeno exemplo', 'teste', '', 1, 2019, 1, '', '', '', '', 1, 2, 1, '2019-05-27', '0', '0', '0000000000020');
INSERT INTO public.livro VALUES (9, 'java na cabeça 7', 'java', '', 1, 2019, 1, '', '', '', '', 2, 2, 1, '2019-05-27', '0', '0', '0000000000009');
INSERT INTO public.livro VALUES (10, 'java na cabeça 2', 'java', '', 1, 2019, 1, '', '', '', '', 2, 2, 1, '2019-05-27', '0', '0', '0000000000010');
INSERT INTO public.livro VALUES (24, 'pequeno exemplo', 'teste', '', 1, 2019, 1, '', '', '', '', 1, 2, 1, '2019-05-27', '0', '0', '0000000000024');
INSERT INTO public.livro VALUES (14, 'sandisk', 'uma grande aventura', '', 1, 2019, 1, '', '', '', '', 3, 2, 1, '2019-05-27', '0', '0', '0000000000014');
INSERT INTO public.livro VALUES (16, 'pequeno exemplo', 'teste', '', 1, 2019, 1, '', '', '', '', 1, 2, 1, '2019-05-27', '0', '0', '0000000000016');
INSERT INTO public.livro VALUES (17, 'pequeno exemplo', 'teste', '', 1, 2019, 1, '', '', '', '', 1, 2, 1, '2019-05-27', '0', '0', '0000000000017');
INSERT INTO public.livro VALUES (12, 'java na cabeça 6', 'java', '', 1, 2019, 1, '', '', '', '', 2, 2, 1, '2019-05-27', '0', '0', '0000000000012');
INSERT INTO public.livro VALUES (11, 'java na cabeça 1', 'java', '', 1, 2019, 1, '', '', '', '', 2, 2, 1, '2019-05-27', '1', '0', '0000000000011');
INSERT INTO public.livro VALUES (18, 'pequeno exemplo', 'teste', '', 1, 2019, 1, '', '', '', '', 1, 2, 1, '2019-05-27', '0', '0', '0000000000018');
INSERT INTO public.livro VALUES (19, 'pequeno exemplo', 'teste', '', 1, 2019, 1, '', '', '', '', 1, 2, 1, '2019-05-27', '0', '0', '0000000000019');
INSERT INTO public.livro VALUES (15, 'pequeno exemplo', 'teste', '', 1, 2019, 1, '', '', '', '', 1, 2, 1, '2019-05-27', '1', '0', '0000000000015');
INSERT INTO public.livro VALUES (21, 'pequeno exemplo', 'teste', '', 1, 2019, 1, '', '', '', '', 1, 2, 1, '2019-05-27', '1', '0', '0000000000021');
INSERT INTO public.livro VALUES (23, 'pequeno exemplo', 'teste', '', 1, 2019, 1, '', '', '', '', 1, 2, 1, '2019-05-27', '0', '0', '0000000000023');
INSERT INTO public.livro VALUES (22, 'pequeno exemplo', 'teste', '', 1, 2019, 1, '', '', '', '', 1, 2, 1, '2019-05-27', '1', '0', '0000000000022');
INSERT INTO public.livro VALUES (13, 'java na cabeça 5', 'java', '', 1, 2019, 1, '', '', '', '', 2, 2, 1, '2019-05-27', '0', '0', '0000000000013');
INSERT INTO public.livro VALUES (8, 'adianti', 'adianti solutions', '', 1, 2019, 7, '', '', '', '', 1, 2, 1, '2019-05-25', '0', '0', '0000000000008');


--
-- Data for Name: livro_assunto; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.livro_assunto VALUES (7, 8, 2);
INSERT INTO public.livro_assunto VALUES (10, 2, 1);
INSERT INTO public.livro_assunto VALUES (11, 2, 3);
INSERT INTO public.livro_assunto VALUES (22, 14, 5);
INSERT INTO public.livro_assunto VALUES (23, 10, 1);
INSERT INTO public.livro_assunto VALUES (24, 10, 3);
INSERT INTO public.livro_assunto VALUES (25, 13, 1);
INSERT INTO public.livro_assunto VALUES (26, 13, 3);
INSERT INTO public.livro_assunto VALUES (27, 12, 1);
INSERT INTO public.livro_assunto VALUES (28, 12, 3);
INSERT INTO public.livro_assunto VALUES (29, 9, 1);
INSERT INTO public.livro_assunto VALUES (30, 9, 3);
INSERT INTO public.livro_assunto VALUES (31, 11, 1);
INSERT INTO public.livro_assunto VALUES (32, 11, 3);
INSERT INTO public.livro_assunto VALUES (33, 15, 1);
INSERT INTO public.livro_assunto VALUES (34, 16, 1);
INSERT INTO public.livro_assunto VALUES (36, 18, 1);
INSERT INTO public.livro_assunto VALUES (37, 19, 1);
INSERT INTO public.livro_assunto VALUES (38, 20, 1);
INSERT INTO public.livro_assunto VALUES (39, 21, 1);
INSERT INTO public.livro_assunto VALUES (40, 22, 1);
INSERT INTO public.livro_assunto VALUES (41, 23, 1);
INSERT INTO public.livro_assunto VALUES (42, 24, 1);
INSERT INTO public.livro_assunto VALUES (44, 17, 1);


--
-- Data for Name: livro_autor; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.livro_autor VALUES (10, 8, 2);
INSERT INTO public.livro_autor VALUES (11, 8, 3);
INSERT INTO public.livro_autor VALUES (14, 2, 1);
INSERT INTO public.livro_autor VALUES (15, 2, 2);
INSERT INTO public.livro_autor VALUES (21, 14, 2);
INSERT INTO public.livro_autor VALUES (22, 10, 1);
INSERT INTO public.livro_autor VALUES (23, 13, 1);
INSERT INTO public.livro_autor VALUES (24, 12, 1);
INSERT INTO public.livro_autor VALUES (25, 9, 1);
INSERT INTO public.livro_autor VALUES (26, 11, 1);
INSERT INTO public.livro_autor VALUES (27, 15, 1);
INSERT INTO public.livro_autor VALUES (28, 15, 3);
INSERT INTO public.livro_autor VALUES (29, 16, 1);
INSERT INTO public.livro_autor VALUES (30, 16, 3);
INSERT INTO public.livro_autor VALUES (33, 18, 1);
INSERT INTO public.livro_autor VALUES (34, 18, 3);
INSERT INTO public.livro_autor VALUES (35, 19, 1);
INSERT INTO public.livro_autor VALUES (36, 19, 3);
INSERT INTO public.livro_autor VALUES (37, 20, 1);
INSERT INTO public.livro_autor VALUES (38, 20, 3);
INSERT INTO public.livro_autor VALUES (39, 21, 1);
INSERT INTO public.livro_autor VALUES (40, 21, 3);
INSERT INTO public.livro_autor VALUES (41, 22, 1);
INSERT INTO public.livro_autor VALUES (42, 22, 3);
INSERT INTO public.livro_autor VALUES (43, 23, 1);
INSERT INTO public.livro_autor VALUES (44, 23, 3);
INSERT INTO public.livro_autor VALUES (45, 24, 1);
INSERT INTO public.livro_autor VALUES (46, 24, 3);
INSERT INTO public.livro_autor VALUES (49, 17, 1);
INSERT INTO public.livro_autor VALUES (50, 17, 3);


--
-- Data for Name: login; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.login VALUES (1, 'DEMO', 'demo', 'fe01ce2a7fbac8fafaed7c982a04e229', '0', '0', '0');
INSERT INTO public.login VALUES (2, 'USER', 'user', '81dc9bdb52d04dc20036dbd8313ed055', '0', '0', '1');


--
-- Name: assunto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.assunto_id_seq', 5, true);


--
-- Name: autor_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.autor_id_seq', 3, true);


--
-- Name: cidade_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cidade_id_seq', 1, true);


--
-- Name: class_literaria_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.class_literaria_id_seq', 3, true);


--
-- Name: colecao_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.colecao_id_seq', 2, true);


--
-- Name: editora_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.editora_id_seq', 3, true);


--
-- Name: emprestimo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.emprestimo_id_seq', 33, true);


--
-- Name: leitor_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.leitor_id_seq', 10, true);


--
-- Name: livro_assunto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.livro_assunto_id_seq', 44, true);


--
-- Name: livro_autor_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.livro_autor_id_seq', 50, true);


--
-- Name: livro_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.livro_id_seq', 24, true);


--
-- Name: login_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.login_id_seq', 2, true);


--
-- Name: assunto assunto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.assunto
    ADD CONSTRAINT assunto_pkey PRIMARY KEY (id);


--
-- Name: autor autor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autor
    ADD CONSTRAINT autor_pkey PRIMARY KEY (id);


--
-- Name: cidade cidade_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cidade
    ADD CONSTRAINT cidade_pkey PRIMARY KEY (id);


--
-- Name: class_literaria class_literaria_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.class_literaria
    ADD CONSTRAINT class_literaria_pkey PRIMARY KEY (id);


--
-- Name: colecao colecao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.colecao
    ADD CONSTRAINT colecao_pkey PRIMARY KEY (id);


--
-- Name: editora editora_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.editora
    ADD CONSTRAINT editora_pkey PRIMARY KEY (id);


--
-- Name: emprestimo emprestimo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emprestimo
    ADD CONSTRAINT emprestimo_pkey PRIMARY KEY (id);


--
-- Name: leitor leitor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leitor
    ADD CONSTRAINT leitor_pkey PRIMARY KEY (id);


--
-- Name: livro_assunto livro_assunto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro_assunto
    ADD CONSTRAINT livro_assunto_pkey PRIMARY KEY (id);


--
-- Name: livro_autor livro_autor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro_autor
    ADD CONSTRAINT livro_autor_pkey PRIMARY KEY (id);


--
-- Name: livro livro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro
    ADD CONSTRAINT livro_pkey PRIMARY KEY (id);


--
-- Name: login login_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.login
    ADD CONSTRAINT login_pkey PRIMARY KEY (id);


--
-- Name: livro tupdate_livro; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER tupdate_livro AFTER INSERT ON public.livro FOR EACH ROW EXECUTE PROCEDURE public.fupcodbarraslivro();


--
-- Name: emprestimo emprestimo_id_leitor_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emprestimo
    ADD CONSTRAINT emprestimo_id_leitor_fkey FOREIGN KEY (id_leitor) REFERENCES public.leitor(id);


--
-- Name: emprestimo emprestimo_id_livro_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emprestimo
    ADD CONSTRAINT emprestimo_id_livro_fkey FOREIGN KEY (id_livro) REFERENCES public.livro(id);


--
-- Name: leitor leitor_cidade_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leitor
    ADD CONSTRAINT leitor_cidade_id_fkey FOREIGN KEY (cidade_id) REFERENCES public.cidade(id);


--
-- Name: livro_assunto livro_assunto_id_assunto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro_assunto
    ADD CONSTRAINT livro_assunto_id_assunto_fkey FOREIGN KEY (id_assunto) REFERENCES public.assunto(id);


--
-- Name: livro_assunto livro_assunto_id_livro_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro_assunto
    ADD CONSTRAINT livro_assunto_id_livro_fkey FOREIGN KEY (id_livro) REFERENCES public.livro(id);


--
-- Name: livro_autor livro_autor_id_autor_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro_autor
    ADD CONSTRAINT livro_autor_id_autor_fkey FOREIGN KEY (id_autor) REFERENCES public.autor(id);


--
-- Name: livro_autor livro_autor_id_livro_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro_autor
    ADD CONSTRAINT livro_autor_id_livro_fkey FOREIGN KEY (id_livro) REFERENCES public.livro(id);


--
-- Name: livro livro_id_class_literaria_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro
    ADD CONSTRAINT livro_id_class_literaria_fkey FOREIGN KEY (id_class_literaria) REFERENCES public.class_literaria(id);


--
-- Name: livro livro_id_colecao_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro
    ADD CONSTRAINT livro_id_colecao_fkey FOREIGN KEY (id_colecao) REFERENCES public.colecao(id);


--
-- Name: livro livro_id_editora_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro
    ADD CONSTRAINT livro_id_editora_fkey FOREIGN KEY (id_editora) REFERENCES public.editora(id);


--
-- PostgreSQL database dump complete
--

