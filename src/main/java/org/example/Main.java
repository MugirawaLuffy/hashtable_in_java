package org.example;

public class Main {
    public static void main(String[] args) {
        Hashtable<Person, String> table =
                new Hashtable<>(10, Person.class,
                name -> {
                    int hash = 0;
                    for(int i = 0; i < name.length(); i++) {
                        hash += name.charAt(i);
                    }
                    return hash;
                },
                person -> person.name);
        Person florian = new Person(21, "Florian");
        Person nils = new Person(20, "Nils");
        table.insert(florian);
        table.insert(nils);
        table.print();
        System.out.println(table.remove("Nils").toString());
        table.print();
    }
}