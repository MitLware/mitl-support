package org.mitlware.support;

import java.util.Random;

public interface ProblemClass< Instance > {

	public double numInstances();
	public Instance generate( Random random );
}

// End ///////////////////////////////////////////////////////////////

