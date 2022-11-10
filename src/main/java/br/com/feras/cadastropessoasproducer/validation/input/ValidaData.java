package br.com.feras.cadastropessoasproducer.validation.input;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ValidaData {

  public static LocalDate buscarData(String data) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate d = LocalDate.parse(data, formatter);
    return d;
  }
  public static boolean isFormatoDataValido(String data) {
    try {
      LocalDate d = buscarData(data);
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  public static boolean isDataNascimentoValida(String dataNascimento) {
    LocalDate dataAtual = LocalDate.now();
    LocalDate data = buscarData(dataNascimento);

    if (dataAtual.isBefore(data)){
      return false;
    }
    return true;
  }

  public static boolean isMaiorDe18(String dataNascimento) {
    LocalDate dataAtual = LocalDate.now();
    LocalDate data = buscarData(dataNascimento);

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

  public static boolean isDataFalecimentoValida(String dataNascimento, String dataFalecimento) {
    LocalDate dataAtual = LocalDate.now();
    LocalDate dataNasc = buscarData(dataNascimento);
    LocalDate dataFalec = buscarData(dataFalecimento);

    if (dataAtual.isBefore(dataFalec)){
      return false;
    }
    if (dataFalec.isBefore(dataNasc)){
      return false;
    }
    return true;
  }

}
