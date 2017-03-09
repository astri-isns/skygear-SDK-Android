package io.skygear.skygear;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * The Query Predicate Helper Class.
 */
class QueryPredicate {
    /**
     * Get a keypath representation of a record attribute key.
     *
     * @param key the key
     * @return the json object
     * @throws JSONException the json exception
     */
    static JSONObject keypathRepresentation(String key) throws JSONException {
        JSONObject keypath = new JSONObject();
        keypath.put("$type", "keypath");
        keypath.put("$val", key);

        return keypath;
    }

    /**
     * Get a basic predicate.
     *
     * @param leftOperand  the left operand
     * @param operator     the operator
     * @param rightOperand the right operand
     * @return the predicate
     */
    static JSONArray basicPredicate(Object leftOperand, String operator, Object rightOperand) {
        JSONArray predicateJson = new JSONArray();
        predicateJson.put(operator);
        predicateJson.put(leftOperand);
        predicateJson.put(rightOperand);

        return predicateJson;
    }

    /**
     * Create a function typed predicate.
     *
     * @param functionName the function name
     * @param args         the function argument
     * @return the predicate
     */
    static JSONArray functionPredicate(String functionName, Object[] args) {
        JSONArray predicate = new JSONArray();
        predicate.put("func");
        predicate.put(functionName);

        if (args != null) {
            for (Object perArg : args) {
                predicate.put(perArg);
            }
        }

        return predicate;
    }

    /**
     * Get an inverted predicate.
     *
     * @param anotherJSON the original predicate
     * @return the predicate
     */
    static JSONArray not(JSONArray anotherJSON) {
        JSONArray predicateJson = new JSONArray();
        predicateJson.put("not");
        predicateJson.put(anotherJSON);

        return predicateJson;
    }
}
