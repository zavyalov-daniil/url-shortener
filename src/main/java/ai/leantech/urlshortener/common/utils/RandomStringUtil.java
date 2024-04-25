package ai.leantech.urlshortener.common.utils;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.stereotype.Component;

@Component
public class RandomStringUtil {
    private static final RandomStringGenerator stringGenerator =
            new RandomStringGenerator.Builder()
                    .withinRange(
                            new char[]{'A', 'Z'},
                            new char[]{'a', 'z'},
                            new char[]{'0', '9'}
                    ).get();

    public String nextRandomKey(int size) {
        return stringGenerator.generate(size);
    }
}
