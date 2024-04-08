package acoes;
import models.Conta;

public abstract class Acao { public abstract void realizar(double valor, Conta... conta); }