package cx.lehmann.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.test.core.ConnectHttpProxy;

/**
 *
 * @author <a href="http://oss.lehmann.cx/">Alexander Lehmann</a>
 */

public class HttpProxyVerticle extends AbstractVerticle {

  private static final Logger log = LoggerFactory.getLogger(HttpProxyVerticle.class);

  private Vertx vertx = Vertx.vertx();

  private ConnectHttpProxy proxy;

  public void start(Future<Void> finished) {
    proxy = new ConnectHttpProxy(null);

    proxy.start(vertx, v -> {
      log.info("proxy server started on port " + proxy.getPort());
      finished.complete();
    });
  }
}
