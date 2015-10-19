package com.portfolio.simulator;

/**
 * Simulator service with different implemantations. One of the implementation
 * uses Monte Carlo methodology for performing simulations.
 */
public interface SimulatorService {

	/**
	 *
	 * Perform monte carlo simulation to predict the future value of
	 * {@link Portfolio} given the {@link SimulationParameters}.
	 *
	 * @param portfolio
	 *            The customers {@link Portfolio}.
	 * @param simulationParams
	 *            The current {@link SimulationParameters}.
	 * @return the simulation result {@link FuturePortfolioSimulationResult}.
	 */
	FuturePortfolioSimulationResult performSimulation(Portfolio portfolio, SimulationParameters simulationParams);
}
