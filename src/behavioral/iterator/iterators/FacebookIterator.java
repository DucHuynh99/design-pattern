package behavioral.iterator.iterators;

import behavioral.iterator.profile.Profile;

public class FacebookIterator implements ProfileIterator {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Profile getNext() {
        return null;
    }

    @Override
    public void reset() {

    }
}
