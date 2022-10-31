package com.meli;

import com.meli.Animals.Cat;
import com.meli.Animals.Cow;
import com.meli.Animals.Dog;
import com.meli.Bank.Customers.Basic;
import com.meli.Bank.Customers.DebtCollector;
import com.meli.Bank.Customers.Executive;
import com.meli.Documents.Curriculum;
import com.meli.Documents.PdfBook;
import com.meli.Documents.Person;
import com.meli.Documents.Report;

public class Main {
    public static void main(String[] args) {
        System.out.println("EJERCICIO 1:");
        ejercicioUno();
        System.out.println("\nEJERCICIO 2:");
        ejercicioDos();
        System.out.println("\nEJERCICIO 3:");
        ejercicioTres();
    }

    /**
     * Ejercicio 1
     * */
    public static void ejercicioUno(){
        System.out.println("---------------------------");
        System.out.println("Inicio trx cliente basico");
        Basic basic = new Basic();
        basic.query();
        basic.pay(1000, "telefonía");
        basic.withdrawal(500);
        basic.transactionOk();
        System.out.println("---------------------------");
        System.out.println("Inicio trx cliente cobrador");
        DebtCollector debtCollector = new DebtCollector();
        debtCollector.withdrawal(12000);
        debtCollector.query();
        debtCollector.transactionOk();
        System.out.println("---------------------------");
        System.out.println("Inicio trx cliente ejecutivo");
        Executive executive = new Executive();
        executive.deposit(12000, 1234);
        executive.transfer(12000, 123);
        executive.transactionNoOk();
        System.out.println("---------------------------");
    }
    public static void ejercicioDos(){
        System.out.println("-----------------------");
        Curriculum  curriculum= new Curriculum(new Person("Juan",12,null));
        curriculum.print();
        System.out.println("-----------------------");
        PdfBook pdfBook = new PdfBook(2,"juan","libro","clasica");
        pdfBook.print();
        System.out.println("-----------------------");
        Report report = new Report(10,2,"juan","luis");
        report.print();
    }
    public static void ejercicioTres(){
        System.out.println("-----------------------");
        Cat cat = new Cat();
        cat.makeSound();
        cat.eatMeat();
        System.out.println("-----------------------");
        Dog dog = new Dog();
        dog.makeSound();
        dog.eatMeat();
        System.out.println("-----------------------");
        Cow cow = new Cow();
        cow.makeSound();
        cow.eatGrass();
    }
}