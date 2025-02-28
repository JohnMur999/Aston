package Entity;

import Validating.Validate;

public final class Person implements Comparable<Person> {
    private final String gender;
    private final int age;
    private final String surname;

    private Person(Builder builder) {
        this.gender = builder.gender;
        this.age = builder.age;
        this.surname = builder.surname;
    }

    public static class Builder {
        private String gender;
        private int age;
        private String surname;

        public Builder setGender(String gender) {
            if (!Validate.validateString(gender)) {
                throw new IllegalArgumentException("Пустой пол");
            }
            this.gender = gender;
            return this;
        }

        public Builder setAge(int age) {
            if (!Validate.validateNonNegativeInt(age)) {
                throw new IllegalArgumentException("Отрицательный возраст");
            }
            this.age = age;
            return this;
        }

        public Builder setSurname(String surname) {
            if (!Validate.validateString(surname)) {
                throw new IllegalArgumentException("Пустая фамилия");
            }
            this.surname = surname;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public int compareTo(Person other) {
        return this.surname.compareTo(other.surname);
    }

    @Override
    public String toString() {
        return "Person{" +
                "gender='" + gender + '\'' +
                ", age=" + age +
                ", surname='" + surname + '\'' +
                '}';
    }
}


