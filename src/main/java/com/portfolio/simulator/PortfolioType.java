package com.portfolio.simulator;

/**
 * Defines the portfolio related parameters
 */
public enum PortfolioType {
	AGGRESSIVE(9.4324d, 15.675d),
	VERY_CONSERVATIVE(6.189d, 6.3438d);

	PortfolioType(double returnRateMean, double standardDeviation) {
		this.returnRateMean = returnRateMean;
		this.standardDeviation = standardDeviation;
	}

	private double returnRateMean;
	private double standardDeviation;

	public double getReturnRateMean() {
		return returnRateMean;
	}

	public void setReturnRateMean(double returnRateMean) {
		this.returnRateMean = returnRateMean;
	}

	public double getStandardDeviation() {
		return standardDeviation;
	}

	public void setStandardDeviation(double standardDeviation) {
		this.standardDeviation = standardDeviation;
	}
}
