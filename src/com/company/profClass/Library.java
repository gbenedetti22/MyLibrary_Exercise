package com.company.profClass;

/*Siccome la richiesta di implementazione di alcuni metodi è ambigua/errata
* Ho cambiato la dichiarazione dei metodi in questa interfaccia affinché rispetti la richiesta del professore*/

public interface Library {
    public String[] getByAuthor(String aut);
    // Restituisce l'elenco dei titoli con lo stesso autore aut

    public Book[] getByTitle(String tit);//prima era public String[] getByTitle(String tit);
    // Restituisce l'elenco dei libri che hanno titolo tit

    public Book[] getByPublisher(String pub);//prima era public String[] getByPublisher(String tit);
    // Restituisce l'elenco dei libri pubblicati da pub

    public Book[] getByYear(int y);//prima era public String[] getByYear(String tit);
    // Restituisce l'elenco dei libri pubblicati nell'anno y

    public String[] getAuthorByPublisher(String pub);
    // Restituisce l'elenco degli autori che hanno pubblicato per pub
    
    public String[] getTitleByYear(int year);
    // Restituisce l'elenco dei titoli di libri pubblicati nell'anno year

    public void remove(Book b) throws Exception;
    // Rimuove tutti i libri identici a b dalla libreria, lancia un'eccezione
    // se il libro non e' presente
    
    public void insert(Book b);
    // Inserisce il libro b nella libreria
}

