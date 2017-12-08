package br.com.cnab;

import br.com.iurd.cnab.Cnab240.TipoInscricao;
import br.com.iurd.cnab.Cnab240.TipoRemessaRetorno;

public class TestaCNAB {

	public static void main(String[] args) {
		
		Cnab240 cnab = new Cnab240();
		
		Cnab240.Header h = cnab.new Header();
		
		h.setAgenciaCodigo("3278");
		
		System.out.println(h.toString());
		
		cnab.getHeader().setBanco("237");
		cnab.getHeader().setLote("0000");
		cnab.getHeader().setRegistro("0");
		cnab.getHeader().setInscricaoTipo(TipoInscricao.CNPJ);
		cnab.getHeader().setInscricaoNumero("66592828000194");
		cnab.getHeader().setConvenio("CONVENIO20POSICOES");
		cnab.getHeader().setAgenciaCodigo("3571");
		cnab.getHeader().setAgenciaDigito("8");
		cnab.getHeader().setAgenciaContaDigito("0");
		cnab.getHeader().setContaNumero("14380");
		cnab.getHeader().setContaDigito("4");
		cnab.getHeader().setNomeEmpresa("NOME EMPRESA");
		cnab.getHeader().setNomeBanco("BRADESCO SA");
		cnab.getHeader().setCodigoGeracao(TipoRemessaRetorno.REMESSA);
		
		
		
		
		
		
		
		System.out.println(cnab.getHeader());
		System.out.println("tamanho-->" + cnab.getHeader().toString().length());
		
		System.out.println(cnab.getHeaderLote());
		System.out.println("tamanho-->" + cnab.getHeaderLote().toString().length());
		
	}
	
}
