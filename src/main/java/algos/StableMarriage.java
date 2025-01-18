package algos;

import heap.KMostFrequentStrings;

import java.util.*;

public class StableMarriage {
    static class Person {
        String name;
        String[] preferences;

        Person(String name, String[] preferences) {
            this.name = name;
            this.preferences = preferences;
        }

        static class PersonHeapComparator implements Comparator<Person> {
            public int compare(Person person1, Person person2){
                return person1.name.compareTo(person2.name);
            }
        }

        public String toString(){
            return name;
        }
    }

    class Pair {
        private Person wife;
        private Person husband;

        Pair(Person wife, Person husband) {
            this.wife = wife;
            this.husband = husband;
        }

        public String toString(){
            return "(" + wife.name + "," + husband.name + ")";
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Person> men = new PriorityQueue<Person>(new Person.PersonHeapComparator());
        HashMap<String, Person> women = new HashMap<>();
        Person person1 = new Person("Bob", new String[]{"Kim", "Angela", "Sarah"});
        Person person2 = new Person("Todd", new String[]{"Angela","Sarah","Kim"});
        Person person5 = new Person("Rizzler", new String[]{"Kim", "Angela", "Sarah"});

        Person person3 = new Person("Kim", new String[]{"Rizzler", "Todd","Bob"});
        Person person4 = new Person("Angela", new String[]{"Todd", "Bob", "Rizzler"});
        Person person6 = new Person("Sarah", new String[]{"Rizzler", "Bob", "Todd"});

        men.add(person1);
        men.add(person2);
        men.add(person5);

        women.put(person3.name, person3);
        women.put(person4.name, person4);
        women.put(person6.name, person6);

        System.out.println((new StableMarriage()).getStableMarriages(men, women));

    }

    private String getStableMarriages(Queue<Person> men, HashMap<String, Person> women) {
        HashMap<String, Person> partners = new HashMap<String, Person>();
        while (!men.isEmpty()) {
            Person m = men.peek();
            for (int j = 0; j < m.preferences.length; j++) {
                Person w = women.get(m.preferences[j]);
                Person wifePartner = partners.get(w.name);
                if (wifePartner == null) {
                    partners.put(w.name, m);
                    men.remove();
                    break;
                } else if (!propose(w, m, wifePartner)) {
                    // m remains free
                } else {
                    partners.replace(w.name, m);
                    men.remove();
                    men.add(wifePartner);
                    break;
                }
            }
        }

        return partners.toString();
    }

    private boolean propose(Person woman, Person man, Person wifePartner) {
        String[] wifePreferences = woman.preferences;
        boolean partnerPreferred = false;
        for (int i = 0; i < wifePreferences.length; i++) {
            if (wifePreferences[i].equals(man.name) && !partnerPreferred) {
                return true;
            }
            if (wifePreferences[i].equals(wifePartner.name)) {
                partnerPreferred = true;
            }
        }

        return false;
    }
}
