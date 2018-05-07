package com.anshishagua.jGenerator.distribution;

/**
 * User: lixiao
 * Date: 2018/5/7
 * Time: 上午10:38
 */

public enum DistributionType {
    Uniform(UniformDistribution.class),
    Gaussian(GaussianDistribution.class);

    private Class<?> clazz;

    DistributionType(Class<?> clazz) {
        this.clazz = clazz;
    }
}