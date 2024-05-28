package chnine;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Nfa {
    private final Set<Integer> states;
    private final Map<Integer, Map<Character, Set<Integer>>> transitions;
    private int initialState;
    private final Set<Integer> finalStates;

    public Nfa() {
        states = new HashSet<>();
        transitions = new HashMap<>();
        finalStates = new HashSet<>();
    }

    public void addState(int state) {
        states.add(state);
    }

    public void setInitialState(int state) {
        initialState = state;
    }

    public void addFinalState(int state) {
        finalStates.add(state);
    }

    public void addTransition(int fromState, char input, int toState) {
        if (input == '+') {
            closure(fromState).forEach(state -> addTransition(state, '.', toState));
        } else {
            if (!transitions.containsKey(fromState)) {
                transitions.put(fromState, new HashMap<>());
            }
            Map<Character, Set<Integer>> transitionsFromState = transitions.get(fromState);
            if (!transitionsFromState.containsKey(input)) {
                transitionsFromState.put(input, new HashSet<>());
            }
            transitionsFromState.get(input).add(toState);
        }
    }

    private Set<Integer> closure(int state) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> queue = new HashSet<>();
        queue.add(state);
        visited.add(state);

        while (!queue.isEmpty()) {
            int currentState = queue.iterator().next();
            queue.remove(currentState);

            if (transitions.containsKey(currentState) && transitions.get(currentState).containsKey('.')) {
                for (int nextState : transitions.get(currentState).get('.')) {
                    if (!visited.contains(nextState)) {
                        visited.add(nextState);
                        queue.add(nextState);
                    }
                }
            }
        }

        return visited;
    }

    public Set<Integer> move(int state, char input) {
        Set<Integer> nextStates = new HashSet<>();
        if (transitions.containsKey(state)) {
            Map<Character, Set<Integer>> transitionsFromState = transitions.get(state);
            if (transitionsFromState.containsKey(input)) {
                nextStates.addAll(transitionsFromState.get(input));
            } else if (transitionsFromState.containsKey('.')) {
                nextStates.addAll(transitionsFromState.get('.'));
            }
        }
        return nextStates;
    }

    public boolean accepts(String input) {
        Set<Integer> currentStates = new HashSet<>();
        currentStates.add(initialState);
        for (int i = 0; i < input.length(); i++) {
            Set<Integer> nextStates = new HashSet<>();
            for (int state : currentStates) {
                nextStates.addAll(move(state, input.charAt(i)));
            }
            currentStates = nextStates;
        }
        for (int state : currentStates) {
            if (finalStates.contains(state)) {
                return true;
            }
        }
        return false;
    }
}
