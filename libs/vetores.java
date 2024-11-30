package libs;

import java.util.Random;
import java.util.Arrays;

public class vetores {
    public static int[] alocarInteiros(int n) {
        int[] vetor = new int[n];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = 0;
        }
        return vetor;
    }

    public static float[] alocarReais(int n) {
        float[] vetor = new float[n];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = 0;
        }
        return vetor;
    }

    public static boolean[] alocarLogicos(int n) {
        boolean[] vetor = new boolean[n];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = false;
        }
        return vetor;
    }

    public static char[] alocarCaracteres(int n) {
        char[] vetor = new char[n];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = '\0';
        }
        return vetor;
    }

    public static int BuscaSequencial(int[] v, int x) {
        int i;
        for (i = 0; i < v.length; i++) {
            if (v[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static int[] gerarValoresAleatorios(int n, int valor_min, int valor_max) {
        Random random = new Random();
        int[] vetor = new int[n];

        for (int i = 0; i < n; i++) {
            // Gera um número aleatório entre min (inclusivo) e max (inclusivo),
            // e salva na posição i do vetor
            vetor[i] = random.nextInt(valor_max - valor_min + 1) + valor_min;
        }

        return vetor;
    }

    public static int[] gerarValoresAleatoriosOrdenado(int n, int valor_min, int valor_max) {

        // Obtém um vetor de valores aleatórios
        int[] vetor = gerarValoresAleatorios(n, valor_min, valor_max);

        // Ordena o vetor antes de retornar
        Arrays.sort(vetor);

        return vetor;
    }

    public static int BuscaBinaria(int[] vetor, int valor_buscar) {
        int ini, fim, meio;

        ini = 0;
        fim = vetor.length;

        while (ini <= fim) {
            meio = (int) (ini + fim) / 2;
            if (vetor[meio] == valor_buscar) {
                return meio;
            } else {
                if (valor_buscar < vetor[meio]) {
                    fim = meio - 1;
                } else if (valor_buscar > vetor[meio]) {
                    ini = meio + 1;
                }
            }

        }

        return -1;

    }

    public static void trocar(int[] v, int i, int j) {
        int tmp;
        tmp = v[i];
        v[i] = v[j];
        v[j] = tmp;

    }

    public static void ordenarInsertionSort(int[] v) {
        int i, j;
        for (i = 1; i < v.length; i++) {
            j = i;
            while (j > 0 && v[j] < v[j - 1]) {
                trocar(v, j, j - 1);
                j--;
            }
        }
    }

    public static void ordenarSelectionSort(int[] v) {
        int i, j, menor_val, menor_pos;
        for (i = 0; i < v.length - 1; i++) {
            menor_val = v[i];
            menor_pos = i;
            for (j = i + 1; j < v.length; j++) {
                if (v[j] < menor_val) {
                    menor_val = v[j];
                    menor_pos = j;
                }
            }
            trocar(v, i, menor_pos);
        }
    }

    public static int[] ordenarMergeSort(int[] va, int[] vb) {
        int i = 0, j = 0, k = 0;
        int vc[] = new int[va.length + vb.length];

        while (i < va.length && j < vb.length) {
            if (va[i] < vb[j]) {
                vc[k] = va[i];
                i++;
            } else {
                vc[k] = vb[j];
                j++;
            }
            k++;
        }
        while (i < va.length) {
            vc[k] = va[i];
            i++;
            k++;
        }
        while (j < vb.length) {
            vc[k] = vb[j];
            j++;
            k++;
        }
        return vc;

    }

    public static int[] subVetor(int[] v, int ini, int fim) {
        int i, k = 0;

        int[] sub_vetor = new int[fim - ini];

        for (i = ini; i < fim; i++) {
            sub_vetor[k] = v[i];
            k++;
        }

        return sub_vetor;
    }

    public static int[] mergeSort(int[] v){
        int[] ve_ordenado,vd_ordenado,v_ordenado;

        if(v.length <= 1){
            return v;
        }


        int[] v_esq, v_dir;
        int meio;

        meio = v.length/2;
        v_esq = subVetor(v, 0, meio);
        v_dir = subVetor(v,meio, v.length);

        ve_ordenado=mergeSort(v_esq);
        vd_ordenado=mergeSort(v_dir);

        v_ordenado = ordenarMergeSort(ve_ordenado,vd_ordenado);

        return v_ordenado;
    }

    public static void mostrarVetor(int[] v) {
        int i;
        System.out.print("[");
        for (i = 0; i < v.length -1; i++) {
            System.out.print(+v[i] + " ");
        }
        System.out.println("]");

    }

    public static int[] countingSort(int[] v){
        int[] contadores = new int[10];
        int[] contadores_acumulado = new int[10];
        int[] resultado = new int [v.length];
        
        int i;

        for(i = 0;i<v.length;i++){
            contadores[v[i]]++;
        }

        for(i=1;i<contadores.length;i++){
             contadores_acumulado[i] = contadores[i-1]+contadores_acumulado[i-1];                   
        }

        for(i=0;i<v.length;i++){
            resultado[contadores_acumulado[v[i]]]=v[i];
            contadores_acumulado[v[i]]++;
        }

        return resultado; 
       }
}
