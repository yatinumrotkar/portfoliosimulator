package com.portfolio.simulator;

/**
 * Main class for testing two simulations of types
 *
 * <pre>
 * 1. With {@link PortfolioType} of AGGRESSIVE.
 * 2. With {@link PortfolioType} of VERY_CONSERVATIVE.
 * </pre>
 *
 * The result of each of simulation is used for calculating the median and 10 %
 * best case and 10 % worst case values.
 *
 */
public class MonteCarloFutureValue {

	/* Assumed inflation per year */
	final static double inflation = 3.5;
	/* Number of years for which analysis needs to be run */
	final static int yearsOfSimulation = 20;
	/* Number of monte carlo runs to be conducted */
	final static int monteCarloRuns = 10000;
	/* Initial portfolio value */
	final static double startingInvestment = 100000;

	public static void main(String[] args) {
		final SimulatorService service = new PortfolioSimulatorService();
		final Portfolio portfolio = new Portfolio(startingInvestment);

		/* Run simulations for AGGRESIVE type */
		final SimulationParameters simulation1 = new SimulationParameters(PortfolioType.AGGRESSIVE, inflation, monteCarloRuns, yearsOfSimulation);
		final FuturePortfolioSimulationResult result1 = service.performSimulation(portfolio, simulation1);
		printSimulationResult(PortfolioType.AGGRESSIVE, result1);

		/* Run simulations for VERY_CONSERVATIVE type */
		final SimulationParameters simulation2 = new SimulationParameters(PortfolioType.VERY_CONSERVATIVE, inflation, monteCarloRuns, yearsOfSimulation);
		final FuturePortfolioSimulationResult result2 = service.performSimulation(portfolio, simulation2);
		printSimulationResult(PortfolioType.VERY_CONSERVATIVE, result2);
	}

	private static void printSimulationResult(final PortfolioType type, FuturePortfolioSimulationResult result) {
		System.out.println("\nResults for portfolio type = " + type);
		System.out.println("Median of 20th Year = " + result.getMedian());
		System.out.println("10 % Best case = " + result.getBest(.9d));
		System.out.println("10 % Worst case = " + result.getBest(.1d));
	}
}