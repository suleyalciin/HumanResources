package com.example.HR.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;







    @Entity // bu sınıfın model sınıfı olduğunu belirtir // bu anatasyon,bu sınıfın bir veritabanı tablosuna karşılık geldiğini beliritr

    public class Employee {


        @Id // bu anatasyon,id alanının birinci anahtar olduğunu belirtir
    @GeneratedValue ( strategy = GenerationType.IDENTITY) // Bu id alanının otomatik olarak arttırılacağını beliritir

    private Long Id; // çalışanın benzersiz kimliği

    private String name; // çalısanın adı

        private String lastName;

    private String position; // calısanin pozisyonu


        public Long getId() {
            return Id;
        }

        public void setId(Long id) {
            Id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }
 // getter ve setter metotları
// getter özel alanların değerini okumak icin kullanılır
// setter özel alanların değerini ayarlamak için kullanılır

