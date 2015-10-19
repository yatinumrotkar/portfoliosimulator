package com.portfolio.simulator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MonteCarloFutureValueTest {
	final SimulatorService service = new PortfolioSimulatorService();

	@Test
	public void testPerformSimulationForAggresive() {
		final Portfolio portfolio = new Portfolio(100000d);

		final SimulationParameters simulation1 = new SimulationParameters(PortfolioType.AGGRESSIVE, 3.5, 10000, 20);
		final FuturePortfolioSimulationResult result1 = service.performSimulation(portfolio, simulation1);

		Assert.assertNotNull(result1.getMedian());
		Assert.assertNotEquals(result1.getMedian(), 100000d);
		Assert.assertNotNull(result1.getBest(0.1d));
		Assert.assertNotNull(result1.getBest(0.9d));
	}

	@Test
	public void testPerformSimulationForCOnservative() {
		final Portfolio portfolio = new Portfolio(100000d);

		final SimulationParameters simulation1 = new SimulationParameters(PortfolioType.VERY_CONSERVATIVE, 3.5, 10000, 20);
		final FuturePortfolioSimulationResult result1 = service.performSimulation(portfolio, simulation1);

		Assert.assertNotNull(result1.getMedian());
		Assert.assertNotEquals(result1.getMedian(), 100000d);
		Assert.assertNotNull(result1.getBest(0.1d));
		Assert.assertNotNull(result1.getBest(0.9d));
	}
}
