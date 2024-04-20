package br.com;

import java.io.*;

public class ConcatenateFiles {
    public static void main(String[] args) {
        // Criando e populando o primeiro arquivo
        String arquivo1 = "arquivo1.txt";
        try (PrintWriter writer1 = new PrintWriter(new FileWriter(arquivo1))) {
            writer1.println("Conteúdo do arquivo 1.");
            writer1.println("Esta é a segunda linha do arquivo 1.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Criando e populando o segundo arquivo
        String arquivo2 = "arquivo2.txt";
        try (PrintWriter writer2 = new PrintWriter(new FileWriter(arquivo2))) {
            writer2.println("Conteúdo do arquivo 2.");
            writer2.println("Esta é a segunda linha do arquivo 2.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Concatenando os conteúdos dos arquivos
        String arquivoConcatenado = "arquivo_concatenado.txt";
        try (BufferedWriter writerConcatenado = new BufferedWriter(new FileWriter(arquivoConcatenado))) {
            // Lendo o conteúdo do primeiro arquivo e escrevendo no arquivo concatenado
            BufferedReader reader1 = new BufferedReader(new FileReader(arquivo1));
            String line;
            while ((line = reader1.readLine()) != null) {
                writerConcatenado.write(line);
                writerConcatenado.newLine();
            }
            reader1.close();

            // Lendo o conteúdo do segundo arquivo e escrevendo no arquivo concatenado
            BufferedReader reader2 = new BufferedReader(new FileReader(arquivo2));
            while ((line = reader2.readLine()) != null) {
                writerConcatenado.write(line);
                writerConcatenado.newLine();
            }
            reader2.close();

            System.out.println("Arquivos concatenados com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
