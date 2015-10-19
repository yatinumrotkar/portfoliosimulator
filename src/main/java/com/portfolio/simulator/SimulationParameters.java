package com.portfolio.simulator;

/**
 * Class holding the respective parameters about the current simulation.
 */
public class SimulationParameters {
	private PortfolioType type;
	private Double inflation;
	private int monteCarloRuns;
	private int yearsOfSimulation;

	public SimulationParameters(PortfolioType type, Double inflation, int monteCarloRuns, int yearsOfSimulation) {
		this.type = type;
		this.inflation = inflation;
		this.monteCarloRuns = monteCarloRuns;
		this.yearsOfSimulation = yearsOfSimulation;
	}

	public PortfolioType getType() {
		return type;
	}

	public void setType(PortfolioType type) {
		this.type = type;
	}

	public Double getInflation() {
		return inflation;
	}

	public void setInflation(Double inflation) {
		this.inflation = inflation;
	}

	public int getMonteCarloRuns() {
		return monteCarloRuns;
	}

	public void setMonteCarloRuns(int monteCarloRuns) {
		this.monteCarloRuns = monteCarloRuns;
	}

	public int getYearsOfSimulation() {
		return yearsOfSimulation;
	}

	public void setYearsOfSimulation(int yearsOfSimulation) {
		this.yearsOfSimulation = yearsOfSimulation;
	}

}
