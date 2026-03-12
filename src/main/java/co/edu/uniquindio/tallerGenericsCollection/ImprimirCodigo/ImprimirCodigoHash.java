package co.edu.uniquindio.tallerGenericsCollection.ImprimirCodigo;

import java.util.LinkedHashSet;
import java.util.Set;

public class ImprimirCodigoHash {
        public static void main(String[] args) {
            Set set = new LinkedHashSet();
            set.add(new String("Chicago"));
            set.add(new String("Boston"));
            set.add(new String("Alabama"));
            set.add(new String("Chicago"));
            System.out.println(set);
        }
    }


