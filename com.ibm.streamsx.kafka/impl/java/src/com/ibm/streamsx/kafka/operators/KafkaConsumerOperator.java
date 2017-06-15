/* Generated by Streams Studio: April 24, 2017 at 1:58:21 PM EDT */
package com.ibm.streamsx.kafka.operators;

import com.ibm.streams.operator.model.Icons;
import com.ibm.streams.operator.model.OutputPortSet;
import com.ibm.streams.operator.model.OutputPortSet.WindowPunctuationOutputMode;
import com.ibm.streams.operator.model.OutputPorts;
import com.ibm.streams.operator.model.PrimitiveOperator;

@PrimitiveOperator(name = "KafkaConsumer", namespace = "com.ibm.streamsx.kafka", description=KafkaConsumerOperator.DESC)
@OutputPorts({
        @OutputPortSet(description = "This port produces tuples based on records read from the Kafka topic(s). A tuple will be output for "
        		+ "each record read from the Kafka topic(s).", cardinality = 1, optional = false, windowPunctuationOutputMode = WindowPunctuationOutputMode.Generating) })
@Icons(location16 = "icons/KafkaConsumer_16.gif", location32 = "icons/KafkaConsumer_32.gif")
public class KafkaConsumerOperator extends AbstractKafkaConsumerOperator {

	public static final String DESC = 
    		"The KafkaConsumer operator is used to consume messages from Kafka topics. "
    		+ "The operator can be configured to consume messages from one or more topics, "
    		+ "as well as consume messages from specific partitions within topics.\\n"
    		+ "\\n"
    		+ "# Kafka Properties\\n" + 
    		"\\n" + 
    		"The operator implements Kafka's KafkaConsumer API. As a result, it supports all "
    		+ "Kafka properties that are supported by the underlying API. Properties can be "
    		+ "specified in a file or in an application configuration. If specifying properties "
    		+ "via a file, the **propertiesFile** parameter can be used. If specifying properties "
    		+ "in an application configuration, the name of the application configuration can be "
    		+ "specified using the **appConfig** parameter. \\n" + 
    		"\\n" + 
    		"The only property that the user is required to set is the `bootstrap.servers` property, "
    		+ "which points to the Kafka brokers. All other properties are optional. The operator "
    		+ "sets some properties by default to enable users to quickly get started with the operator. "
    		+ "The following lists which properties the operator sets by default: \\n" + 
    		"\\n" + 
    		"---\\n" + 
    		"| Property Name | Default Value |\\n" + 
    		"|===|\\n" + 
    		"| client.id | Randomly generated ID in the form: `client-<random_string>` |\\n" + 
    		"|---|\\n" + 
    		"| group.id | Randomly generated ID in the form: `group-<random_string>` |\\n" + 
    		"|---|\\n" + 
    		"| key.deserializer | See **Automatic deserialization** section below |\\n" + 
    		"|---|\\n" + 
    		"| value.deserializer | See **Automatic deserialization** section below |\\n" + 
    		"---\\n" + 
    		"\\n" + 
    		"**NOTE:** Users can override any of the above properties by explicitly setting the property "
    		+ "value in either a properties file or in an application configuration.\\n"
    		+ "\\n"
    		+ "# Automatic Seserialization\\n" + 
    		"\\n" + 
    		"The operator will automatically select the appropriate deserializers for the key and message "
    		+ "based on their types. The following table outlines which deserializer will be used given a "
    		+ "particular type: \\n" + 
    		"\\n" + 
    		"---\\n" + 
    		"| Deserializer | SPL Types |\\n" + 
    		"|===|\\n" + 
    		"| org.apache.kafka.common.serialization.StringDeserializer | rstring |\\n" + 
    		"|---|\\n" + 
    		"| org.apache.kafka.common.serialization.IntegerDeserializer | int32, uint32 |\\n" + 
    		"|---|\\n" + 
    		"| org.apache.kafka.common.serialization.LongDeserializer | int64, uint64 |\\n" + 
    		"|---|\\n" + 
    		"| org.apache.kafka.common.serialization.DoubleDeserializer | float64 |\\n" + 
    		"|---|\\n" + 
    		"| org.apache.kafka.common.serialization.ByteArrayDeserializer | blob | \\n" + 
    		"---\\n" + 
    		"\\n" + 
    		"Users can override this behaviour and specify which deserializer to use by setting the "
    		+ "`key.deserializer` and `value.deserializer` properties. \\n" + 
    		"\\n" + 
    		"# Kafka's Group Management\\n" + 
    		"\\n" + 
    		"The operator is capable of taking advantage of Kafka's group management functionality. "
    		+ "In order for the operator to use this functionality, the following requirements "
    		+ "must be met\\n" + 
    		"\\n" + 
    		"* The operator cannot be in a consistent region\\n" + 
    		"* The **startPosition** parameter value cannot be `Beginning` (must be `End` or not specified)\\n" + 
    		"* None of the topics specified by the **topics** parameter can specify which partition to be assigned to\\n" + 
    		"\\n" + 
    		"In addition to the above, the application needs to set the `group.id` Kafka property in "
    		+ "order to assign the KafkaConsumer to a specific group. \\n" + 
    		"\\n" + 
    		"# Consistent Region Support\\n" + 
    		"\\n" + 
    		"The `KafkaConsumer` operator can participate in a consistent region. The operator "
    		+ "can be the start of a consistent region. Both operator driven and periodic checkpointing "
    		+ "are supported. If using operator driven, the **triggerCount** parameter must be set to "
    		+ "indicate how often the operator should initiate a consistent region. On checkpoint, the "
    		+ "operator will save the last offset for each topic-partition that it is assigned to. In the "
    		+ "event of a reset, the operator will seek to the saved offset for each topic-partition and "
    		+ "begin consuming messages from that point." +
    		"\\n" + 
			"\\n" + 
			"# Error Handling\\n" + 
			"\\n" + 
			"Many exceptions thrown by the underlying Kafka API are considered fatal. In the event that Kafak throws "
			+ "an exception, the operator will restart.\\n";
}
