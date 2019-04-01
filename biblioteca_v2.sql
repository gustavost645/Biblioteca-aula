PGDMP                         w         
   biblioteca    11.1    11.1 5    F           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            G           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            H           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            I           1262    16393 
   biblioteca    DATABASE     �   CREATE DATABASE biblioteca WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE biblioteca;
             postgres    false            �            1259    16548    assunto    TABLE     M   CREATE TABLE public.assunto (
    id integer NOT NULL,
    descricao text
);
    DROP TABLE public.assunto;
       public         postgres    false            �            1259    16546    assunto_id_seq    SEQUENCE     �   CREATE SEQUENCE public.assunto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.assunto_id_seq;
       public       postgres    false    203            J           0    0    assunto_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.assunto_id_seq OWNED BY public.assunto.id;
            public       postgres    false    202            �            1259    16537    autor    TABLE     F   CREATE TABLE public.autor (
    id integer NOT NULL,
    nome text
);
    DROP TABLE public.autor;
       public         postgres    false            �            1259    16535    autor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.autor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.autor_id_seq;
       public       postgres    false    201            K           0    0    autor_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.autor_id_seq OWNED BY public.autor.id;
            public       postgres    false    200            �            1259    16515    cidade    TABLE     d   CREATE TABLE public.cidade (
    id integer NOT NULL,
    nome text,
    uf character varying(2)
);
    DROP TABLE public.cidade;
       public         postgres    false            �            1259    16513    cidade_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cidade_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.cidade_id_seq;
       public       postgres    false    197            L           0    0    cidade_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.cidade_id_seq OWNED BY public.cidade.id;
            public       postgres    false    196            �            1259    16570    class_literaria    TABLE     U   CREATE TABLE public.class_literaria (
    id integer NOT NULL,
    descricao text
);
 #   DROP TABLE public.class_literaria;
       public         postgres    false            �            1259    16568    class_literaria_id_seq    SEQUENCE     �   CREATE SEQUENCE public.class_literaria_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.class_literaria_id_seq;
       public       postgres    false    207            M           0    0    class_literaria_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.class_literaria_id_seq OWNED BY public.class_literaria.id;
            public       postgres    false    206            �            1259    16559    colecao    TABLE     M   CREATE TABLE public.colecao (
    id integer NOT NULL,
    descricao text
);
    DROP TABLE public.colecao;
       public         postgres    false            �            1259    16557    colecao_id_seq    SEQUENCE     �   CREATE SEQUENCE public.colecao_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.colecao_id_seq;
       public       postgres    false    205            N           0    0    colecao_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.colecao_id_seq OWNED BY public.colecao.id;
            public       postgres    false    204            �            1259    16526    editora    TABLE     M   CREATE TABLE public.editora (
    id integer NOT NULL,
    descricao text
);
    DROP TABLE public.editora;
       public         postgres    false            �            1259    16524    editora_id_seq    SEQUENCE     �   CREATE SEQUENCE public.editora_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.editora_id_seq;
       public       postgres    false    199            O           0    0    editora_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.editora_id_seq OWNED BY public.editora.id;
            public       postgres    false    198            �            1259    16581    login    TABLE     �   CREATE TABLE public.login (
    id integer NOT NULL,
    nome text,
    login character varying(45),
    password character varying(45),
    status character varying(1),
    del character varying(1)
);
    DROP TABLE public.login;
       public         postgres    false            �            1259    16579    login_id_seq    SEQUENCE     �   CREATE SEQUENCE public.login_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.login_id_seq;
       public       postgres    false    209            P           0    0    login_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.login_id_seq OWNED BY public.login.id;
            public       postgres    false    208            �
           2604    16551 
   assunto id    DEFAULT     h   ALTER TABLE ONLY public.assunto ALTER COLUMN id SET DEFAULT nextval('public.assunto_id_seq'::regclass);
 9   ALTER TABLE public.assunto ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    203    202    203            �
           2604    16540    autor id    DEFAULT     d   ALTER TABLE ONLY public.autor ALTER COLUMN id SET DEFAULT nextval('public.autor_id_seq'::regclass);
 7   ALTER TABLE public.autor ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    200    201    201            �
           2604    16518 	   cidade id    DEFAULT     f   ALTER TABLE ONLY public.cidade ALTER COLUMN id SET DEFAULT nextval('public.cidade_id_seq'::regclass);
 8   ALTER TABLE public.cidade ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    197    196    197            �
           2604    16573    class_literaria id    DEFAULT     x   ALTER TABLE ONLY public.class_literaria ALTER COLUMN id SET DEFAULT nextval('public.class_literaria_id_seq'::regclass);
 A   ALTER TABLE public.class_literaria ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    207    206    207            �
           2604    16562 
   colecao id    DEFAULT     h   ALTER TABLE ONLY public.colecao ALTER COLUMN id SET DEFAULT nextval('public.colecao_id_seq'::regclass);
 9   ALTER TABLE public.colecao ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    205    204    205            �
           2604    16529 
   editora id    DEFAULT     h   ALTER TABLE ONLY public.editora ALTER COLUMN id SET DEFAULT nextval('public.editora_id_seq'::regclass);
 9   ALTER TABLE public.editora ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    198    199    199            �
           2604    16584    login id    DEFAULT     d   ALTER TABLE ONLY public.login ALTER COLUMN id SET DEFAULT nextval('public.login_id_seq'::regclass);
 7   ALTER TABLE public.login ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    208    209    209            =          0    16548    assunto 
   TABLE DATA               0   COPY public.assunto (id, descricao) FROM stdin;
    public       postgres    false    203   �3       ;          0    16537    autor 
   TABLE DATA               )   COPY public.autor (id, nome) FROM stdin;
    public       postgres    false    201   �3       7          0    16515    cidade 
   TABLE DATA               .   COPY public.cidade (id, nome, uf) FROM stdin;
    public       postgres    false    197   4       A          0    16570    class_literaria 
   TABLE DATA               8   COPY public.class_literaria (id, descricao) FROM stdin;
    public       postgres    false    207   ;4       ?          0    16559    colecao 
   TABLE DATA               0   COPY public.colecao (id, descricao) FROM stdin;
    public       postgres    false    205   X4       9          0    16526    editora 
   TABLE DATA               0   COPY public.editora (id, descricao) FROM stdin;
    public       postgres    false    199   �4       C          0    16581    login 
   TABLE DATA               G   COPY public.login (id, nome, login, password, status, del) FROM stdin;
    public       postgres    false    209   �4       Q           0    0    assunto_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.assunto_id_seq', 1, false);
            public       postgres    false    202            R           0    0    autor_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.autor_id_seq', 1, true);
            public       postgres    false    200            S           0    0    cidade_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.cidade_id_seq', 5, true);
            public       postgres    false    196            T           0    0    class_literaria_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.class_literaria_id_seq', 1, false);
            public       postgres    false    206            U           0    0    colecao_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.colecao_id_seq', 2, true);
            public       postgres    false    204            V           0    0    editora_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.editora_id_seq', 1, true);
            public       postgres    false    198            W           0    0    login_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.login_id_seq', 1, true);
            public       postgres    false    208            �
           2606    16556    assunto assunto_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.assunto
    ADD CONSTRAINT assunto_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.assunto DROP CONSTRAINT assunto_pkey;
       public         postgres    false    203            �
           2606    16545    autor autor_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.autor
    ADD CONSTRAINT autor_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.autor DROP CONSTRAINT autor_pkey;
       public         postgres    false    201            �
           2606    16523    cidade cidade_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.cidade
    ADD CONSTRAINT cidade_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.cidade DROP CONSTRAINT cidade_pkey;
       public         postgres    false    197            �
           2606    16578 $   class_literaria class_literaria_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.class_literaria
    ADD CONSTRAINT class_literaria_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.class_literaria DROP CONSTRAINT class_literaria_pkey;
       public         postgres    false    207            �
           2606    16567    colecao colecao_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.colecao
    ADD CONSTRAINT colecao_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.colecao DROP CONSTRAINT colecao_pkey;
       public         postgres    false    205            �
           2606    16534    editora editora_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.editora
    ADD CONSTRAINT editora_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.editora DROP CONSTRAINT editora_pkey;
       public         postgres    false    199            �
           2606    16589    login login_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.login
    ADD CONSTRAINT login_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.login DROP CONSTRAINT login_pkey;
       public         postgres    false    209            =      x������ � �      ;   #   x�3�tq�Wq����wus������ a�l      7      x�3��q�rut��
����� %i�      A      x������ � �      ?      x�3�����2�tv�w	s����� =b�      9      x�3���sq�����  H\      C   D   x�3�tq��L/-.I,��L54HLI6�4�LJ4�LLJJ55K505O32H��0N�4�4������ }�     