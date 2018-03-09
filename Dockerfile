FROM jboss/wildfly:11.0.0.Final
USER jboss
RUN /opt/jboss/wildfly/bin/add-user.sh admin Jboss@admin01 --silent
COPY /simplejavaee-web/target/webapp.war /opt/jboss/wildfly/standalone/deployments
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0", "--debug"]
