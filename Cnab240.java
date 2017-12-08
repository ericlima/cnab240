package br.com.iurd.cnab;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

public class Cnab240 {

	private final static char CR  = (char) 0x0D;
	private final static char LF  = (char) 0x0A; 

	private final static String CRLF  = "" + CR + LF;  
	
	public enum TipoRemessaRetorno {
		REMESSA("1"),
		RETORNO("2");
		private String tipo;
		TipoRemessaRetorno(String tipo) {
			this.tipo = tipo;
		}
		public String getTipo() {
			return this.tipo;
		}
	}
	
	public enum TipoMoeda {
		BTN("Bônus do Tesouro Nacional + TR"),
		BRL("Real"),
		USD("Dólar Americano"),
		PTE("Escudo Português"),
		FRF("Franco Francês"),
		CHF("Franco Suíço"),
		JPY("Ien Japonês"),
		IGP("Índice Geral de Preços"),
		IGM("Índice Geral de Preços de Mercado"),
		GBP("Libra Esterlina"),
		ITL("Lira Italiana"),
		DEM("Marco Alemão"),
		TRD("Taxa Referencial Diária"),
		UPC("Unidade Padrão de Capital"),
		UPF("Unidade Padrão de Financiamento"),
		UFR("Unidade Fiscal de Referência"),
		XEU("Unidade Monetária Européia");
		
		private String descricao;
		
		TipoMoeda(String descricao) {
			this.setDescricao(descricao);
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
	}
	
	public enum TipoInscricao {
		ISENTO("0"),
		CPF("1"),
		CNPJ("2"),
		PIS("3"),
		OUTROS("9");
		
		private String codigo;
		
		TipoInscricao(String codigo) {
			this.codigo = codigo;
		}
		
		public String toString() {
			return this.codigo;
		}
		
	}
	
	public class Header {
		private String banco; 		
		private String lote;  		
		private String registro;	
		private String filler1;		
		private TipoInscricao inscricaoTipo;
		private String inscricaoNumero;
		private String convenio;
		private String agenciaCodigo;
		private String agenciaDigito;
		private String contaNumero;
		private String contaDigito;
		private String agenciaContaDigito;
		private String nomeEmpresa;
		private String nomeBanco;
		private String filler2;
		private TipoRemessaRetorno codigoGeracao;
		private String dataGeracao;
		private String horaGeracao;
		private String nsa;
		private String layout;
		private String densidade;
		private String filler3;
		private String filler4;
		private String filler5;
		
		public Header() {
			lote = "0000";
			registro = "0";
			layout = "080";
			filler1 = StringUtils.rightPad("", 9);
			filler2 = StringUtils.rightPad("", 10);
			filler3 = StringUtils.rightPad("", 10);
			filler4 = StringUtils.rightPad("", 10);
			filler5 = StringUtils.rightPad("", 10);
			banco = ""; 		
			inscricaoTipo = TipoInscricao.OUTROS;
			inscricaoNumero = "";
			convenio = "";
			agenciaCodigo = "";
			agenciaDigito = "";
			contaNumero = "";
			contaDigito = "";
			agenciaContaDigito = "";
			nomeEmpresa = "";
			nomeBanco = "";
			codigoGeracao = TipoRemessaRetorno.REMESSA;
			dataGeracao = "";
			horaGeracao = "";
			nsa = "";
			densidade = "";
		}
		
		public String toString() {
			return 	StringUtils.leftPad(this.banco, 3, "0")+
					StringUtils.leftPad(this.lote, 4, "0")+
					StringUtils.leftPad(this.registro, 1, "0")+
					StringUtils.rightPad(this.filler1, 9, " ")+
					StringUtils.leftPad(this.inscricaoTipo.toString(), 1, "0")+
					StringUtils.leftPad(this.inscricaoNumero, 14, "0")+
					StringUtils.rightPad(this.convenio, 20, " ")+
					StringUtils.leftPad(this.agenciaCodigo, 5, "0")+
					StringUtils.rightPad(this.agenciaDigito, 1, " ")+
					StringUtils.leftPad(this.contaNumero, 12, "0")+
					StringUtils.rightPad(this.contaDigito, 1, " ")+
					StringUtils.rightPad(this.agenciaContaDigito, 1, " ")+
					StringUtils.rightPad(this.nomeEmpresa, 30, " ")+
					StringUtils.rightPad(this.nomeBanco, 30, " ")+
					StringUtils.rightPad(this.filler2, 10, " ")+
					StringUtils.leftPad(this.codigoGeracao.getTipo(), 1, "0")+
					StringUtils.leftPad(this.dataGeracao, 8, "0")+
					StringUtils.leftPad(this.horaGeracao, 6, "0")+
					StringUtils.leftPad(this.nsa, 6, "0")+
					StringUtils.leftPad(this.layout, 3, "0")+
					StringUtils.leftPad(this.densidade, 5, "0")+
					StringUtils.rightPad(this.filler3, 20, " ")+
					StringUtils.rightPad(this.filler4, 20, " ")+
					StringUtils.rightPad(this.filler5, 29, " ")+
					CRLF;
		}

		public String getBanco() {
			return banco;
		}

		public void setBanco(String banco) {
			this.banco = banco;
		}

		public String getLote() {
			return lote;
		}

		public void setLote(String lote) {
			this.lote = lote;
		}

		public String getRegistro() {
			return registro;
		}

		public void setRegistro(String registro) {
			this.registro = registro;
		}

		public String getFiller1() {
			return filler1;
		}

		public void setFiller1(String filler1) {
			this.filler1 = filler1;
		}

		public TipoInscricao getInscricaoTipo() {
			return inscricaoTipo;
		}

		public void setInscricaoTipo(TipoInscricao inscricaoTipo) {
			this.inscricaoTipo = inscricaoTipo;
		}

		public String getInscricaoNumero() {
			return inscricaoNumero;
		}

		public void setInscricaoNumero(String inscricaoNumero) {
			this.inscricaoNumero = inscricaoNumero;
		}

		public String getConvenio() {
			return convenio;
		}

		public void setConvenio(String convenio) {
			this.convenio = convenio;
		}

		public String getAgenciaCodigo() {
			return agenciaCodigo;
		}

		public void setAgenciaCodigo(String agenciaCodigo) {
			this.agenciaCodigo = agenciaCodigo;
		}

		public String getAgenciaDigito() {
			return agenciaDigito;
		}

		public void setAgenciaDigito(String agenciaDigito) {
			this.agenciaDigito = agenciaDigito;
		}

		public String getContaNumero() {
			return contaNumero;
		}

		public void setContaNumero(String contaNumero) {
			this.contaNumero = contaNumero;
		}

		public String getContaDigito() {
			return contaDigito;
		}

		public void setContaDigito(String contaDigito) {
			this.contaDigito = contaDigito;
		}

		public String getAgenciaContaDigito() {
			return agenciaContaDigito;
		}

		public void setAgenciaContaDigito(String agenciaContaDigito) {
			this.agenciaContaDigito = agenciaContaDigito;
		}

		public String getNomeEmpresa() {
			return nomeEmpresa;
		}

		public void setNomeEmpresa(String nomeEmpresa) {
			this.nomeEmpresa = nomeEmpresa;
		}

		public String getNomeBanco() {
			return nomeBanco;
		}

		public void setNomeBanco(String nomeBanco) {
			this.nomeBanco = nomeBanco;
		}

		public String getFiller2() {
			return filler2;
		}

		public void setFiller2(String filler2) {
			this.filler2 = filler2;
		}

		public TipoRemessaRetorno getCodigoGeracao() {
			return codigoGeracao;
		}

		public void setCodigoGeracao(TipoRemessaRetorno codigoGeracao) {
			this.codigoGeracao = codigoGeracao;
		}

		public String getDataGeracao() {
			return dataGeracao;
		}

		public void setDataGeracao(String dataGeracao) {
			this.dataGeracao = dataGeracao;
		}

		public String getHoraGeracao() {
			return horaGeracao;
		}

		public void setHoraGeracao(String horaGeracao) {
			this.horaGeracao = horaGeracao;
		}

		public String getNsa() {
			return nsa;
		}

		public void setNsa(String nsa) {
			this.nsa = nsa;
		}

		public String getLayout() {
			return layout;
		}

		public void setLayout(String layout) {
			this.layout = layout;
		}

		public String getDensidade() {
			return densidade;
		}

		public void setDensidade(String densidade) {
			this.densidade = densidade;
		}

		public String getFiller3() {
			return filler3;
		}

		public void setFiller3(String filler3) {
			this.filler3 = filler3;
		}

		public String getFiller4() {
			return filler4;
		}

		public void setFiller4(String filler4) {
			this.filler4 = filler4;
		}

		public String getFiller5() {
			return filler5;
		}

		public void setFiller5(String filler5) {
			this.filler5 = filler5;
		}
		
	}
	
	public class HeaderLote {
		private String banco; //3
		private String lote; //4
		private String registro; //1
		private String operacao; //1
		private String servico; //2
		private String formaLancamento; //2
		private String layoutLote; //3
		private String filler1; //1
		private TipoInscricao inscricaoTipo; //1
		private String inscricaoNumero; //14
		private String convenio; //20
		private String agencia; //5
		private String agenciaDigito; //1
		private String conta; //12
		private String contaDigito; //1
		private String agenciaContaDigito; //1
		private String nomeEmpresa; //30
		private String mensagem; //40
		private String logradouro; //30
		private String numero; //5
		private String complemento; //15
		private String cidade; //20
		private String cep; //5
		private String cepComplemento; //3
		private String estado; //2
		private String filler2; //8
		private String ocorrencias; //10
		
		public HeaderLote() {
			registro = "1";
			operacao = "C";
			layoutLote = "040";
			filler1 = " ";
			filler2 = " ";
			
			banco = " "; //3
			lote = " "; //4
			servico = " "; //2
			formaLancamento = " "; //2
			inscricaoTipo = TipoInscricao.OUTROS; //1
			inscricaoNumero = " "; //14
			convenio = " "; //20
			agencia = " "; //5
			agenciaDigito = " "; //1
			conta = " "; //12
			contaDigito = " "; //1
			agenciaContaDigito = " "; //1
			nomeEmpresa = " "; //30
			mensagem = " "; //40
			logradouro = " "; //30
			numero = " "; //5
			complemento = " "; //15
			cidade = " "; //20
			cep = " "; //5
			cepComplemento = " "; //3
			estado = " "; //2
			ocorrencias = " "; //10
			
		}
		
		public String toString() {
			return StringUtils.leftPad(this.banco, 3, "0")+
					StringUtils.leftPad(this.lote, 4, "0")+
					StringUtils.leftPad(this.registro, 1, "0")+
					StringUtils.rightPad(this.operacao, 1, " ")+
					StringUtils.leftPad(this.servico, 2, "0")+
					StringUtils.leftPad(this.formaLancamento, 2, "0")+
					StringUtils.leftPad(this.layoutLote, 3, "0")+
					StringUtils.rightPad(this.filler1, 1, " ")+
					StringUtils.leftPad(this.inscricaoTipo.toString(), 1, "0")+
					StringUtils.leftPad(this.inscricaoNumero, 14, "0")+
					StringUtils.rightPad(this.convenio, 20, " ")+
					StringUtils.leftPad(this.agencia, 5, "0")+
					StringUtils.rightPad(this.agenciaDigito, 1, " ")+
					StringUtils.leftPad(this.conta, 12, "0")+
					StringUtils.rightPad(this.contaDigito, 1, " ")+
					StringUtils.rightPad(this.agenciaContaDigito, 1, " ")+
					StringUtils.rightPad(this.nomeEmpresa, 30, " ")+
					StringUtils.rightPad(this.mensagem, 40, " ")+
					StringUtils.rightPad(this.logradouro, 30, " ")+
					StringUtils.leftPad(this.numero, 5, "0")+
					StringUtils.rightPad(this.complemento, 15, " ")+
					StringUtils.rightPad(this.cidade, 20, " ")+
					StringUtils.leftPad(this.cep, 5, "0")+
					StringUtils.leftPad(this.cepComplemento, 3, " ")+
					StringUtils.rightPad(this.estado, 2, " ")+
					StringUtils.rightPad(this.filler2, 8, " ")+
					StringUtils.rightPad(this.ocorrencias, 10, " ")+
					CRLF;
		}

		public String getBanco() {
			return banco;
		}

		public void setBanco(String banco) {
			this.banco = banco;
		}

		public String getLote() {
			return lote;
		}

		public void setLote(String lote) {
			this.lote = lote;
		}

		public String getRegistro() {
			return registro;
		}

		public void setRegistro(String registro) {
			this.registro = registro;
		}

		public String getOperacao() {
			return operacao;
		}

		public void setOperacao(String operacao) {
			this.operacao = operacao;
		}

		public String getServico() {
			return servico;
		}

		public void setServico(String servico) {
			this.servico = servico;
		}

		public String getFormaLancamento() {
			return formaLancamento;
		}

		public void setFormaLancamento(String formaLancamento) {
			this.formaLancamento = formaLancamento;
		}

		public String getLayoutLote() {
			return layoutLote;
		}

		public void setLayoutLote(String layoutLote) {
			this.layoutLote = layoutLote;
		}

		public String getFiller1() {
			return filler1;
		}

		public void setFiller1(String filler1) {
			this.filler1 = filler1;
		}

		public TipoInscricao getInscricaoTipo() {
			return inscricaoTipo;
		}

		public void setInscricaoTipo(TipoInscricao inscricaoTipo) {
			this.inscricaoTipo = inscricaoTipo;
		}

		public String getInscricaoNumero() {
			return inscricaoNumero;
		}

		public void setInscricaoNumero(String inscricaoNumero) {
			this.inscricaoNumero = inscricaoNumero;
		}

		public String getConvenio() {
			return convenio;
		}

		public void setConvenio(String convenio) {
			this.convenio = convenio;
		}

		public String getAgencia() {
			return agencia;
		}

		public void setAgencia(String agencia) {
			this.agencia = agencia;
		}

		public String getAgenciaDigito() {
			return agenciaDigito;
		}

		public void setAgenciaDigito(String agenciaDigito) {
			this.agenciaDigito = agenciaDigito;
		}

		public String getConta() {
			return conta;
		}

		public void setConta(String conta) {
			this.conta = conta;
		}

		public String getContaDigito() {
			return contaDigito;
		}

		public void setContaDigito(String contaDigito) {
			this.contaDigito = contaDigito;
		}

		public String getAgenciaContaDigito() {
			return agenciaContaDigito;
		}

		public void setAgenciaContaDigito(String agenciaContaDigito) {
			this.agenciaContaDigito = agenciaContaDigito;
		}

		public String getNomeEmpresa() {
			return nomeEmpresa;
		}

		public void setNomeEmpresa(String nomeEmpresa) {
			this.nomeEmpresa = nomeEmpresa;
		}

		public String getMensagem() {
			return mensagem;
		}

		public void setMensagem(String mensagem) {
			this.mensagem = mensagem;
		}

		public String getLogradouro() {
			return logradouro;
		}

		public void setLogradouro(String logradouro) {
			this.logradouro = logradouro;
		}

		public String getNumero() {
			return numero;
		}

		public void setNumero(String numero) {
			this.numero = numero;
		}

		public String getComplemento() {
			return complemento;
		}

		public void setComplemento(String complemento) {
			this.complemento = complemento;
		}

		public String getCidade() {
			return cidade;
		}

		public void setCidade(String cidade) {
			this.cidade = cidade;
		}

		public String getCep() {
			return cep;
		}

		public String getCepComplemento() {
			return cepComplemento;
		}

		public void setCepComplemento(String cepComplemento) {
			this.cepComplemento = cepComplemento;
		}

		public void setCep(String cep) {
			this.cep = cep;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}

		public String getFiller2() {
			return filler2;
		}

		public void setFiller2(String filler2) {
			this.filler2 = filler2;
		}

		public String getOcorrencias() {
			return ocorrencias;
		}

		public void setOcorrencias(String ocorrencias) {
			this.ocorrencias = ocorrencias;
		}
		
		
	}

	public class DetalheA {
		private String banco; // 3
		private String lote; //4
		private String registroTipo; //1
		private String registroNumero; //5
		private String segmento; //1
		private String movimentoTipo; //1
		private String movimentoCodigo; //2
		private String camara; //3
		private String bancoFavorecido; //3
		private String agenciaFavorecido; //5
		private String agenciaDigitoFavorecido; //1
		private String contaFavorecido; //12
		private String contaDigitoFavorecido; //1
		private String agenciaContaDigitoFavorecido; //1
		private String nomeFavorecido; //30
		private String seuNumero; //20
		private String dataPagamento; //8
		private TipoMoeda moedaTipo; //3
		private BigDecimal moedaQuantidade; //10,5
		private BigDecimal valorPagamento; //13,2
		private String nossoNumero; //20
		private String dataPagamentoReal; //8
		private BigDecimal valorPagamentoReal; //13,2
		private String informacao2; //40
		private String codigoFinalidadeDOC; //2
		private String codigoFinalidadeTED; //5
		private String filler1; //5
		private String avisoFavorecido; //1
		private String ocorrencias; //10
		
		public DetalheA() {
			registroTipo = "3";
			segmento = "A";
			
			banco = ""; // 3
			lote = ""; //4
			registroNumero = ""; //5
			movimentoTipo = ""; //1
			movimentoCodigo = ""; //2
			camara = ""; //3
			bancoFavorecido = ""; //3
			agenciaFavorecido = ""; //5
			agenciaDigitoFavorecido = ""; //1
			contaFavorecido = ""; //12
			contaDigitoFavorecido = ""; //1
			agenciaContaDigitoFavorecido = ""; //1
			nomeFavorecido = ""; //30
			seuNumero = ""; //20
			dataPagamento = ""; //8
			moedaTipo = TipoMoeda.BRL; //3
			moedaQuantidade = new BigDecimal(0); //10,5
			valorPagamento = new BigDecimal(0); //13,2
			nossoNumero = ""; //20
			dataPagamentoReal = ""; //8
			valorPagamentoReal = new BigDecimal(0); //13,2
			informacao2 = ""; //40
			codigoFinalidadeDOC = ""; //2
			codigoFinalidadeTED = ""; //5
			filler1 = ""; //5
			avisoFavorecido =""; //1
			ocorrencias = ""; //10
		}
		
		public String toString() {
			return StringUtils.leftPad(this.banco, 3, "0")+
					StringUtils.leftPad(this.lote, 4, "0")+
					StringUtils.leftPad(this.registroTipo, 1, "0")+
					StringUtils.rightPad(this.registroNumero, 5, " ")+
					StringUtils.leftPad(this.segmento, 1, "0")+
					StringUtils.leftPad(this.movimentoTipo, 1, "0")+
					StringUtils.leftPad(this.movimentoCodigo, 2, "0")+
					StringUtils.rightPad(this.camara, 3, " ")+
					StringUtils.leftPad(this.bancoFavorecido, 3, "0")+
					StringUtils.leftPad(this.agenciaFavorecido, 5, "0")+
					StringUtils.rightPad(this.agenciaDigitoFavorecido, 1, " ")+
					StringUtils.leftPad(this.contaFavorecido, 12, "0")+
					StringUtils.rightPad(this.contaDigitoFavorecido, 1, " ")+
					StringUtils.leftPad(this.agenciaContaDigitoFavorecido, 1, "0")+
					StringUtils.rightPad(this.nomeFavorecido, 30, " ")+
					StringUtils.rightPad(this.seuNumero, 20, " ")+
					StringUtils.rightPad(this.dataPagamento, 8, " ")+
					StringUtils.rightPad(this.moedaTipo.name(), 3, " ")+
					StringUtils.leftPad(this.moedaQuantidade.multiply(new BigDecimal(100000)).toString().trim(), 10, "0")+
					StringUtils.leftPad(this.valorPagamento.multiply(new BigDecimal(100)).toString().trim(), 13, "0")+
					StringUtils.rightPad(this.nossoNumero, 20, " ")+
					StringUtils.rightPad(this.dataPagamentoReal, 8, " ")+
					StringUtils.leftPad(this.valorPagamentoReal.multiply(new BigDecimal(100)).toString().trim(), 13, "0")+
					StringUtils.rightPad(this.informacao2, 40, " ")+
					StringUtils.rightPad(this.codigoFinalidadeDOC, 2, " ")+
					StringUtils.rightPad(this.codigoFinalidadeTED, 5, " ")+
					StringUtils.rightPad(this.filler1, 5, " ")+
					StringUtils.leftPad(this.avisoFavorecido, 1, "0")+
					StringUtils.rightPad(this.ocorrencias, 10, " ")+
					CRLF;
		}


		

		public String getMovimentoTipo() {
			return movimentoTipo;
		}

		public void setMovimentoTipo(String movimentoTipo) {
			this.movimentoTipo = movimentoTipo;
		}

		public String getMovimentoCodigo() {
			return movimentoCodigo;
		}

		public void setMovimentoCodigo(String movimentoCodigo) {
			this.movimentoCodigo = movimentoCodigo;
		}

		public String getCamara() {
			return camara;
		}

		public void setCamara(String camara) {
			this.camara = camara;
		}

		public String getBancoFavorecido() {
			return bancoFavorecido;
		}

		public void setBancoFavorecido(String bancoFavorecido) {
			this.bancoFavorecido = bancoFavorecido;
		}

		public String getAgenciaFavorecido() {
			return agenciaFavorecido;
		}

		public void setAgenciaFavorecido(String agenciaFavorecido) {
			this.agenciaFavorecido = agenciaFavorecido;
		}

		public String getAgenciaDigitoFavorecido() {
			return agenciaDigitoFavorecido;
		}

		public void setAgenciaDigitoFavorecido(String agenciaDigitoFavorecido) {
			this.agenciaDigitoFavorecido = agenciaDigitoFavorecido;
		}

		public String getContaFavorecido() {
			return contaFavorecido;
		}

		public void setContaFavorecido(String contaFavorecido) {
			this.contaFavorecido = contaFavorecido;
		}

		public String getContaDigitoFavorecido() {
			return contaDigitoFavorecido;
		}

		public void setContaDigitoFavorecido(String contaDigitoFavorecido) {
			this.contaDigitoFavorecido = contaDigitoFavorecido;
		}

		public String getAgenciaContaDigitoFavorecido() {
			return agenciaContaDigitoFavorecido;
		}

		public void setAgenciaContaDigitoFavorecido(String agenciaContaDigitoFavorecido) {
			this.agenciaContaDigitoFavorecido = agenciaContaDigitoFavorecido;
		}

		public String getNomeFavorecido() {
			return nomeFavorecido;
		}

		public void setNomeFavorecido(String nomeFavorecido) {
			this.nomeFavorecido = nomeFavorecido;
		}

		public String getSeuNumero() {
			return seuNumero;
		}

		public void setSeuNumero(String seuNumero) {
			this.seuNumero = seuNumero;
		}

		public String getDataPagamento() {
			return dataPagamento;
		}

		public void setDataPagamento(String dataPagamento) {
			this.dataPagamento = dataPagamento;
		}

		public TipoMoeda getMoedaTipo() {
			return moedaTipo;
		}

		public void setMoedaTipo(TipoMoeda moedaTipo) {
			this.moedaTipo = moedaTipo;
		}

		public BigDecimal getMoedaQuantidade() {
			return moedaQuantidade;
		}

		public void setMoedaQuantidade(BigDecimal moedaQuantidade) {
			this.moedaQuantidade = moedaQuantidade;
		}

		public BigDecimal getValorPagamento() {
			return valorPagamento;
		}

		public void setValorPagamento(BigDecimal valorPagamento) {
			this.valorPagamento = valorPagamento;
		}

		public String getNossoNumero() {
			return nossoNumero;
		}

		public void setNossoNumero(String nossoNumero) {
			this.nossoNumero = nossoNumero;
		}

		public String getDataPagamentoReal() {
			return dataPagamentoReal;
		}

		public void setDataPagamentoReal(String dataPagamentoReal) {
			this.dataPagamentoReal = dataPagamentoReal;
		}

		public BigDecimal getValorPagamentoReal() {
			return valorPagamentoReal;
		}

		public void setValorPagamentoReal(BigDecimal valorPagamentoReal) {
			this.valorPagamentoReal = valorPagamentoReal;
		}

		public String getInformacao2() {
			return informacao2;
		}

		public void setInformacao2(String informacao2) {
			this.informacao2 = informacao2;
		}

		public String getCodigoFinalidadeDOC() {
			return codigoFinalidadeDOC;
		}

		public void setCodigoFinalidadeDOC(String codigoFinalidadeDOC) {
			this.codigoFinalidadeDOC = codigoFinalidadeDOC;
		}

		public String getCodigoFinalidadeTED() {
			return codigoFinalidadeTED;
		}

		public void setCodigoFinalidadeTED(String codigoFinalidadeTED) {
			this.codigoFinalidadeTED = codigoFinalidadeTED;
		}

		public String getFiller1() {
			return filler1;
		}

		public void setFiller1(String filler1) {
			this.filler1 = filler1;
		}

		public String getAvisoFavorecido() {
			return avisoFavorecido;
		}

		public void setAvisoFavorecido(String avisoFavorecido) {
			this.avisoFavorecido = avisoFavorecido;
		}

		public String getOcorrencias() {
			return ocorrencias;
		}

		public void setOcorrencias(String ocorrencias) {
			this.ocorrencias = ocorrencias;
		}

		public String getBanco() {
			return banco;
		}

		public void setBanco(String banco) {
			this.banco = banco;
		}

		public String getLote() {
			return lote;
		}

		public void setLote(String lote) {
			this.lote = lote;
		}

		public String getRegistroTipo() {
			return registroTipo;
		}

		public String getRegistroNumero() {
			return registroNumero;
		}

		public void setRegistroNumero(String registroNumero) {
			this.registroNumero = registroNumero;
		}

		public String getSegmento() {
			return segmento;
		}

		public void setSegmento(String segmento) {
			this.segmento = segmento;
		}

		public void setRegistroTipo(String registroTipo) {
			this.registroTipo = registroTipo;
		}
		
	}

	public class DetalheB {
		private String banco; //3
		private String lote; //4
		private String registroTipo; //1
		private String registroNumero; //5
		private String segmento; //1
		private String filler1; //3
		private TipoInscricao inscricaoTipo; //1
		private String inscricaoNumero; //14
		private String logradouro; //30
		private String numero; //5
		private String complemento; //15
		private String bairro; //15
		private String cidade; //20
		private String cep; //5
		private String cepComplemento; //3
		private String estado; //2
		private String vencimento; //8
		private BigDecimal valor; //13
		private BigDecimal abatimento; //13
		private BigDecimal desconto; //13
		private BigDecimal mora; //13
		private BigDecimal multa; //13
		private String codDocFavorecido; //15
		private String filler2; //15
		
		public DetalheB() {
			registroTipo = "3";
			segmento = "B";
			filler1 = " ";
			filler2 = " ";
			
			banco = " "; //3
			lote = " "; //4
			registroNumero = " "; //5
			inscricaoTipo = TipoInscricao.OUTROS; //1
			inscricaoNumero = " "; //14
			logradouro = " "; //30
			numero = " "; //5
			complemento = " "; //15
			bairro = " "; //15
			cidade = " "; //20
			cep = " "; //5
			cepComplemento = " "; //3
			estado = " "; //2
			vencimento = " "; //8
			valor = new BigDecimal(0); //13
			abatimento = new BigDecimal(0); //13
			desconto = new BigDecimal(0); //13
			mora = new BigDecimal(0); //13
			multa = new BigDecimal(0); //13
			codDocFavorecido = " "; //15
		}
		
		public String toString() {
			return StringUtils.leftPad(this.banco, 3, "0")+
					StringUtils.leftPad(this.lote, 4, "0")+
					StringUtils.leftPad(this.registroTipo, 1, "0")+
					StringUtils.rightPad(this.registroNumero, 5, " ")+
					StringUtils.leftPad(this.segmento, 1, "0")+
					StringUtils.leftPad(this.filler1, 3, "0")+
					StringUtils.leftPad(this.inscricaoTipo.toString(), 1, "0")+
					StringUtils.rightPad(this.inscricaoNumero, 14, " ")+
					StringUtils.leftPad(this.logradouro, 30, "0")+
					StringUtils.leftPad(this.numero, 5, "0")+
					StringUtils.rightPad(this.complemento, 15, " ")+
					StringUtils.leftPad(this.bairro, 15, "0")+
					StringUtils.rightPad(this.cidade, 20, " ")+
					StringUtils.leftPad(this.cep, 5, "0")+
					StringUtils.rightPad(this.cepComplemento, 3, " ")+
					StringUtils.rightPad(this.estado, 2, " ")+
					StringUtils.rightPad(this.vencimento, 8, " ")+
					StringUtils.leftPad(this.valor.multiply(new BigDecimal(100)).toString().trim(), 13, "0")+
					StringUtils.leftPad(this.abatimento.multiply(new BigDecimal(100)).toString().trim(), 13, "0")+
					StringUtils.leftPad(this.desconto.multiply(new BigDecimal(100)).toString().trim(), 13, "0")+
					StringUtils.leftPad(this.mora.multiply(new BigDecimal(100)).toString().trim(), 13, "0")+
					StringUtils.leftPad(this.multa.multiply(new BigDecimal(100)).toString().trim(), 13, "0")+
					StringUtils.rightPad(this.codDocFavorecido, 15, " ")+
					StringUtils.rightPad(this.filler2, 15, " ")+
					CRLF;
		}

		public String getBanco() {
			return banco;
		}

		public void setBanco(String banco) {
			this.banco = banco;
		}

		public String getLote() {
			return lote;
		}

		public void setLote(String lote) {
			this.lote = lote;
		}

		public String getRegistroTipo() {
			return registroTipo;
		}

		public void setRegistroTipo(String registroTipo) {
			this.registroTipo = registroTipo;
		}

		public String getRegistroNumero() {
			return registroNumero;
		}

		public void setRegistroNumero(String registroNumero) {
			this.registroNumero = registroNumero;
		}

		public String getSegmento() {
			return segmento;
		}

		public void setSegmento(String segmento) {
			this.segmento = segmento;
		}

		public String getFiller1() {
			return filler1;
		}

		public void setFiller1(String filler1) {
			this.filler1 = filler1;
		}

		public TipoInscricao getInscricaoTipo() {
			return inscricaoTipo;
		}

		public void setInscricaoTipo(TipoInscricao inscricaoTipo) {
			this.inscricaoTipo = inscricaoTipo;
		}

		public String getInscricaoNumero() {
			return inscricaoNumero;
		}

		public void setInscricaoNumero(String inscricaoNumero) {
			this.inscricaoNumero = inscricaoNumero;
		}

		public String getLogradouro() {
			return logradouro;
		}

		public void setLogradouro(String logradouro) {
			this.logradouro = logradouro;
		}

		public String getNumero() {
			return numero;
		}

		public void setNumero(String numero) {
			this.numero = numero;
		}

		public String getComplemento() {
			return complemento;
		}

		public void setComplemento(String complemento) {
			this.complemento = complemento;
		}

		public String getBairro() {
			return bairro;
		}

		public void setBairro(String bairro) {
			this.bairro = bairro;
		}

		public String getCidade() {
			return cidade;
		}

		public void setCidade(String cidade) {
			this.cidade = cidade;
		}

		public String getCep() {
			return cep;
		}

		public void setCep(String cep) {
			this.cep = cep;
		}

		public String getCepComplemento() {
			return cepComplemento;
		}

		public void setCepComplemento(String cepComplemento) {
			this.cepComplemento = cepComplemento;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}

		public String getVencimento() {
			return vencimento;
		}

		public void setVencimento(String vencimento) {
			this.vencimento = vencimento;
		}

		public BigDecimal getValor() {
			return valor;
		}

		public void setValor(BigDecimal valor) {
			this.valor = valor;
		}

		public BigDecimal getAbatimento() {
			return abatimento;
		}

		public void setAbatimento(BigDecimal abatimento) {
			this.abatimento = abatimento;
		}

		public BigDecimal getDesconto() {
			return desconto;
		}

		public void setDesconto(BigDecimal desconto) {
			this.desconto = desconto;
		}

		public BigDecimal getMora() {
			return mora;
		}

		public void setMora(BigDecimal mora) {
			this.mora = mora;
		}

		public BigDecimal getMulta() {
			return multa;
		}

		public void setMulta(BigDecimal multa) {
			this.multa = multa;
		}

		public String getCodDocFavorecido() {
			return codDocFavorecido;
		}

		public void setCodDocFavorecido(String codDocFavorecido) {
			this.codDocFavorecido = codDocFavorecido;
		}

		public String getFiller2() {
			return filler2;
		}

		public void setFiller2(String filler2) {
			this.filler2 = filler2;
		}
		
	}
	
	public class DetalheC {
		private String banco; //3
		private String lote; //4
		private String registroTipo; //1
		private String registroNumero; //5
		private String segmento; //1
		private String filler1; //3
		private BigDecimal valorIR; //13
		private BigDecimal valorISS; //13
		private BigDecimal valorIOF; //13
		private BigDecimal valorOutras; //13
		private BigDecimal valorOutrosAcescimos; //13
		private String agencia; //5
		private String agenciaDigito; //1
		private String conta; //12
		private String contaDigito; //1
		private String agenciaContaDigito; //1
		private BigDecimal valorINSS; //13
		private String filler2; //113
		
		public DetalheC() {
			filler1 = " ";
			filler2 = " ";
			
			banco = " "; //3
			lote = " "; //4
			registroTipo = " "; //1
			registroNumero = " "; //5
			segmento = " "; //1
			valorIR = new BigDecimal(0); //13
			valorISS = new BigDecimal(0); //13
			valorIOF = new BigDecimal(0); //13
			valorOutras = new BigDecimal(0); //13
			valorOutrosAcescimos = new BigDecimal(0); //13
			agencia = " "; //5
			agenciaDigito = " "; //1
			conta = " "; //12
			contaDigito = " "; //1
			agenciaContaDigito = " "; //1
			valorINSS = new BigDecimal(0); //13
		}
		
		public String toString() {
			return StringUtils.leftPad(this.banco, 3, "0")+
					StringUtils.leftPad(this.lote, 4, "0")+
					StringUtils.leftPad(this.registroTipo, 1, "0")+
					StringUtils.rightPad(this.registroNumero, 5, " ")+
					StringUtils.leftPad(this.segmento, 1, "0")+
					StringUtils.leftPad(this.filler1, 3, "0")+
					StringUtils.leftPad(this.valorIR.multiply(new BigDecimal(100)).toString().trim(), 13, "0")+
					StringUtils.leftPad(this.valorISS.multiply(new BigDecimal(100)).toString().trim(), 13, "0")+
					StringUtils.leftPad(this.valorIOF.multiply(new BigDecimal(100)).toString().trim(), 13, "0")+
					StringUtils.leftPad(this.valorOutras.multiply(new BigDecimal(100)).toString().trim(), 13, "0")+
					StringUtils.leftPad(this.valorOutrosAcescimos.multiply(new BigDecimal(100)).toString().trim(), 13, "0")+
					StringUtils.leftPad(this.agencia, 5, "0")+
					StringUtils.rightPad(this.agenciaDigito, 1, " ")+
					StringUtils.leftPad(this.conta, 12, "0")+
					StringUtils.rightPad(this.contaDigito, 1, " ")+
					StringUtils.rightPad(this.agenciaContaDigito, 1, " ")+
					StringUtils.leftPad(this.valorINSS.multiply(new BigDecimal(100)).toString().trim(), 13, "0")+
					StringUtils.rightPad(this.filler2, 113, " ")+
					CRLF;
		}

		public String getBanco() {
			return banco;
		}

		public void setBanco(String banco) {
			this.banco = banco;
		}

		public String getLote() {
			return lote;
		}

		public void setLote(String lote) {
			this.lote = lote;
		}

		public String getRegistroTipo() {
			return registroTipo;
		}

		public void setRegistroTipo(String registroTipo) {
			this.registroTipo = registroTipo;
		}

		public String getRegistroNumero() {
			return registroNumero;
		}

		public void setRegistroNumero(String registroNumero) {
			this.registroNumero = registroNumero;
		}

		public String getSegmento() {
			return segmento;
		}

		public void setSegmento(String segmento) {
			this.segmento = segmento;
		}

		public String getFiller1() {
			return filler1;
		}

		public void setFiller1(String filler1) {
			this.filler1 = filler1;
		}

		public BigDecimal getValorIR() {
			return valorIR;
		}

		public void setValorIR(BigDecimal valorIR) {
			this.valorIR = valorIR;
		}

		public BigDecimal getValorISS() {
			return valorISS;
		}

		public void setValorISS(BigDecimal valorISS) {
			this.valorISS = valorISS;
		}

		public BigDecimal getValorIOF() {
			return valorIOF;
		}

		public void setValorIOF(BigDecimal valorIOF) {
			this.valorIOF = valorIOF;
		}

		public BigDecimal getValorOutras() {
			return valorOutras;
		}

		public void setValorOutras(BigDecimal valorOutras) {
			this.valorOutras = valorOutras;
		}

		public BigDecimal getValorOutrosAcescimos() {
			return valorOutrosAcescimos;
		}

		public void setValorOutrosAcescimos(BigDecimal valorOutrosAcescimos) {
			this.valorOutrosAcescimos = valorOutrosAcescimos;
		}

		public String getAgencia() {
			return agencia;
		}

		public void setAgencia(String agencia) {
			this.agencia = agencia;
		}

		public String getAgenciaDigito() {
			return agenciaDigito;
		}

		public void setAgenciaDigito(String agenciaDigito) {
			this.agenciaDigito = agenciaDigito;
		}

		public String getConta() {
			return conta;
		}

		public void setConta(String conta) {
			this.conta = conta;
		}

		public String getContaDigito() {
			return contaDigito;
		}

		public void setContaDigito(String contaDigito) {
			this.contaDigito = contaDigito;
		}

		public String getAgenciaContaDigito() {
			return agenciaContaDigito;
		}

		public void setAgenciaContaDigito(String agenciaContaDigito) {
			this.agenciaContaDigito = agenciaContaDigito;
		}

		public BigDecimal getValorINSS() {
			return valorINSS;
		}

		public void setValorINSS(BigDecimal valorINSS) {
			this.valorINSS = valorINSS;
		}

		public String getFiller2() {
			return filler2;
		}

		public void setFiller2(String filler2) {
			this.filler2 = filler2;
		}
		
	}

	public class TrailerLote {
		private String banco;
		private String lote;
		private String registro;
		private String filler1;
		private Integer qtdRegistros;
		private BigDecimal valor;
		private BigDecimal qtdMoeda;
		private String numeroAvisoDebito;
		private String filler2;
		private String ocorrencias;
		
		public TrailerLote() {
			filler1 = " ";
			filler2 = " ";
			qtdRegistros = new Integer(0);
			valor = new BigDecimal(0);
			qtdMoeda = new BigDecimal(0);
			
			banco = "";
			lote = "";
			registro = "";
			numeroAvisoDebito = "";
			ocorrencias = "";
		}
		
		public String toString() {
			return StringUtils.leftPad(this.banco, 3, "0")+
					StringUtils.leftPad(this.lote, 4, "0")+
					StringUtils.leftPad(this.registro, 1, "0")+
					StringUtils.rightPad(this.filler1, 9, " ")+
					StringUtils.leftPad(this.qtdRegistros.toString().trim(), 6, "0")+
					StringUtils.leftPad(this.valor.multiply(new BigDecimal(100)).toBigInteger().toString().trim(), 13, "0")+
					StringUtils.leftPad(this.qtdMoeda.multiply(new BigDecimal(100000)).toBigInteger().toString().trim(), 13, "0")+
					StringUtils.leftPad(this.numeroAvisoDebito, 6, "0")+
					StringUtils.rightPad(this.filler2, 165, " ")+
					StringUtils.rightPad(this.ocorrencias, 10, " ")+
					CRLF;
		}

		public String getBanco() {
			return banco;
		}

		public void setBanco(String banco) {
			this.banco = banco;
		}

		public String getLote() {
			return lote;
		}

		public void setLote(String lote) {
			this.lote = lote;
		}

		public String getRegistro() {
			return registro;
		}

		public void setRegistro(String registro) {
			this.registro = registro;
		}

		public String getFiller1() {
			return filler1;
		}

		public void setFiller1(String filler1) {
			this.filler1 = filler1;
		}

		public Integer getQtdRegistros() {
			return qtdRegistros;
		}

		public void setQtdRegistros(Integer qtdRegistros) {
			this.qtdRegistros = qtdRegistros;
		}

		public BigDecimal getValor() {
			return valor;
		}

		public void setValor(BigDecimal valor) {
			this.valor = valor;
		}

		public BigDecimal getQtdMoeda() {
			return qtdMoeda;
		}

		public void setQtdMoeda(BigDecimal qtdMoeda) {
			this.qtdMoeda = qtdMoeda;
		}

		public String getNumeroAvisoDebito() {
			return numeroAvisoDebito;
		}

		public void setNumeroAvisoDebito(String numeroAvisoDebito) {
			this.numeroAvisoDebito = numeroAvisoDebito;
		}

		public String getFiller2() {
			return filler2;
		}

		public void setFiller2(String filler2) {
			this.filler2 = filler2;
		}

		public String getOcorrencias() {
			return ocorrencias;
		}

		public void setOcorrencias(String ocorrencias) {
			this.ocorrencias = ocorrencias;
		}
		
		
	}

	public class TrailerArquivo {
		private String banco;
		private String lote;
		private String registro;
		private String filler1;
		private Integer qtdLotes;
		private Integer qtdRegistros;
		private Integer qtdContasConciliacao;
		private String filler2;
		
		private TrailerArquivo() {
			filler1 = " ";
			filler2 = " ";
			qtdLotes = new Integer(0);
			qtdRegistros = new Integer(0);
			qtdContasConciliacao = new Integer(0);
		}
		
		public String toString() {
			return StringUtils.leftPad(this.banco, 3, "0")+
					StringUtils.leftPad(this.lote, 4, "0")+
					StringUtils.leftPad(this.registro, 1, "0")+
					StringUtils.rightPad(this.filler1, 9, " ")+
					StringUtils.leftPad(this.qtdLotes.toString().trim(), 6, "0")+
					StringUtils.leftPad(this.qtdRegistros.toString().trim(), 6, "0")+
					StringUtils.leftPad(this.qtdContasConciliacao.toString().trim(), 6, "0")+
					StringUtils.rightPad(this.filler2, 165, " ")+
					CRLF;
		}

		public String getBanco() {
			return banco;
		}

		public void setBanco(String banco) {
			this.banco = banco;
		}

		public String getLote() {
			return lote;
		}

		public void setLote(String lote) {
			this.lote = lote;
		}

		public String getRegistro() {
			return registro;
		}

		public void setRegistro(String registro) {
			this.registro = registro;
		}

		public String getFiller1() {
			return filler1;
		}

		public void setFiller1(String filler1) {
			this.filler1 = filler1;
		}

		public Integer getQtdLotes() {
			return qtdLotes;
		}

		public void setQtdLotes(Integer qtdLotes) {
			this.qtdLotes = qtdLotes;
		}

		public Integer getQtdRegistros() {
			return qtdRegistros;
		}

		public void setQtdRegistros(Integer qtdRegistros) {
			this.qtdRegistros = qtdRegistros;
		}

		public Integer getQtdContasConciliacao() {
			return qtdContasConciliacao;
		}

		public void setQtdContasConciliacao(Integer qtdContasConciliacao) {
			this.qtdContasConciliacao = qtdContasConciliacao;
		}

		public String getFiller2() {
			return filler2;
		}

		public void setFiller2(String filler2) {
			this.filler2 = filler2;
		}
		
		
		
	}
	
	private Header header;
	private HeaderLote headerLote;
	private DetalheA detalheA;
	private DetalheB detalheB;
	private DetalheC detalheC;
	private TrailerLote trailerLote;
	private TrailerArquivo trailerArquivo;
	
	public Cnab240() {
		header 			= new Header();                 
		headerLote 		= new HeaderLote();         
		detalheA 		= new DetalheA();             
		detalheB 		= new DetalheB();             
		detalheC 		= new DetalheC();             
		trailerLote 	= new TrailerLote();      
		trailerArquivo 	= new TrailerArquivo(); 
	}
	
	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public HeaderLote getHeaderLote() {
		return headerLote;
	}

	public void setHeaderLote(HeaderLote headerLote) {
		this.headerLote = headerLote;
	}

	public DetalheA getDetalheA() {
		return detalheA;
	}

	public void setDetalheA(DetalheA detalheA) {
		this.detalheA = detalheA;
	}

	public DetalheB getDetalheB() {
		return detalheB;
	}

	public void setDetalheB(DetalheB detalheB) {
		this.detalheB = detalheB;
	}

	public DetalheC getDetalheC() {
		return detalheC;
	}

	public void setDetalheC(DetalheC detalheC) {
		this.detalheC = detalheC;
	}

	public TrailerLote getTrailerLote() {
		return trailerLote;
	}

	public void setTrailerLote(TrailerLote trailerLote) {
		this.trailerLote = trailerLote;
	}

	public TrailerArquivo getTrailerArquivo() {
		return trailerArquivo;
	}

	public void setTrailerArquivo(TrailerArquivo trailerArquivo) {
		this.trailerArquivo = trailerArquivo;
	}
	
	
}

