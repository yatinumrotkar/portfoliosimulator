package com.portfolio.simulator;

/**
 * Class holding the results of future value simulations.
 */
public class FuturePortfolioSimulationResult {
	final Double[] futureValues;

	public FuturePortfolioSimulationResult(Double[] futureValues) {
		this.futureValues = futureValues;
	}

	public Double getMedian() {
		if (futureValues.length % 2 == 0) {
			return (this.futureValues[futureValues.length / 2] + this.futureValues[(futureValues.length / 2) - 1]) / 2;
		} else {
			return this.futureValues[futureValues.length / 2];
		}
	}

	public Double getBest(double percentile) {
		return this.futureValues[(int) (futureValues.length * percentile)];
	}
}
