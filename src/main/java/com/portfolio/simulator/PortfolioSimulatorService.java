package com.portfolio.simulator;

import java.util.Arrays;
import java.util.Random;

/**
 * {@link SimulatorService} implementation service which performs monte carlo
 * simulations.
 */
public class PortfolioSimulatorService implements SimulatorService {

	public PortfolioSimulatorService() {
	}

	@Override
	public FuturePortfolioSimulationResult performSimulation(final Portfolio portfolio, final SimulationParameters simulationParams) {

		final Double[] finalValues = new Double[simulationParams.getMonteCarloRuns()];

		for (int j = 0; j < simulationParams.getMonteCarloRuns(); j++) {
			Double value = portfolio.getStartingInvestment();
			final Random r = new Random();
			/*
			 * For each year of simulation, taking into consideration the
			 * portfolio return mean as well as randomly generated standard
			 * deviation to get effective return rate.
			 */
			for (int i = 0; i < simulationParams.getYearsOfSimulation(); i++) {
				final Double deviationAdjustedReturnRate = simulationParams.getType().getReturnRateMean() + getRandomDeviationRate(r, simulationParams.getType().getStandardDeviation());
				/*
				 * Effective interest rate = ((1+ interestRate) / (1 +
				 * inflationRate)) - 1;
				 */
				final Double effectiveReturnRate = (((1 + (deviationAdjustedReturnRate * 0.01)) / (1 + (simulationParams.getInflation() * 0.01))) - 1);

				value = value + (value * (effectiveReturnRate));
			}
			// For each of the monte carlo run collect the final portfolio value
			// in an array.
			finalValues[j] = value;
		}
		// We need to sort this so as find the median and other percentile based
		// values.
		Arrays.sort(finalValues);
		return new FuturePortfolioSimulationResult(finalValues);
	}

	/**
	 * Generate a Random number given a standard deviation.
	 *
	 * @param r
	 *            random number generator.
	 * @param deviation
	 *            standard deviation.
	 * @return the randomly generated number following the standard deviation.
	 */
	private Double getRandomDeviationRate(final Random r, final Double deviation) {
		final Double value = r.nextGaussian() * deviation;
		return value;
	}
}
