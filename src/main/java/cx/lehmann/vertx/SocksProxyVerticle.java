package cx.lehmann.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.test.core.SocksProxy;

/**
 *
 * @author <a href="http://oss.lehmann.cx/">Alexander Lehmann</a>
 */

public class SocksProxyVerticle extends AbstractVerticle {

  private static final Logger log = LoggerFactory.getLogger(SocksProxyVerticle.class);

  private Vertx vertx = Vertx.vertx();

  private SocksProxy proxy;

  public void start(Future<Void> finished) {
    proxy = new SocksProxy(null);

    proxy.start(vertx, v -> {
      log.info("socks server started on port " + proxy.getPort());
      finished.complete();
    });
  }
}
