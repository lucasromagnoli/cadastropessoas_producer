package br.com.feras.cadastropessoasproducer.validation.input;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ValidaData {

  public static LocalDate buscarData(String dataNascimento) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate data = LocalDate.parse(dataNascimento, formatter);
    return data;
  }
  public static boolean isFormatoDataValido(String dataNascimento) {
    try {
      LocalDate d = buscarData(dataNascimento);
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  public static boolean isDataValida(String dataNascimento) {
    LocalDate dataAtual = LocalDate.now();
    LocalDate data = buscarData(dataNascimento);

    if (dataAtual.isBefore(data)){
      return false;
    }

    if ((dataAtual.getYear() - data.getYear()) < 18){
      return false;
    } else if ((dataAtual.getYear() - data.getYear()) == 18) {
      if (dataAtual.getMonthValue() < data.getMonthValue() ){
        return false;
      } else if (dataAtual.getMonthValue() == data.getMonthValue()) {
        if (dataAtual.getDayOfMonth() < data.getDayOfMonth()){
          return false;
        }
      }
    }

    return true;
  }
}
