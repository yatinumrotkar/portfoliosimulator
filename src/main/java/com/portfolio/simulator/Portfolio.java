package com.portfolio.simulator;

/**
 * The customers portfolio.
 */
public class Portfolio {
	private Double startingInvestment;

	public Portfolio(final Double startingInvestment) {
		this.startingInvestment = startingInvestment;
	}

	public Double getStartingInvestment() {
		return startingInvestment;
	}

	public void setStartingInvestment(Double startingInvestment) {
		this.startingInvestment = startingInvestment;
	}
}
