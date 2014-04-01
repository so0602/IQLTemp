/////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2000-2014 Antenna Software Inc., All rights reserved //
//                                                                             //
// This file contains confidential information and is the                      //
// property of Antenna Software Inc., with all the restrictions                //
// therein.                                                                    //
/////////////////////////////////////////////////////////////////////////////////
package iqltemp.gen.images;
import  com.antennasoftware.api.foundation.vscript.VScriptRuntimeException;
import  com.antennasoftware.api.bl.images.ImageResource;
import  com.antennasoftware.api.bl.images.ImageBundle;

public class CURVE extends ImageBundle {
   public CURVE() {
      super("iqltemp.gen.images.CURVE");
      
   }
   
   public void initialize() {
      try {
         _CURVE();
      } catch (Throwable _t_init2_0) {
         throw new VScriptRuntimeException("initialize", _t_init2_0);
      }
      
   }
   
   protected CURVE _D_CURVE() {
      try {
         return this;
      } catch (Throwable _t_fini_0) {
         throw new VScriptRuntimeException("_D_CURVE", _t_fini_0);
      }
      
   }
   
   public CURVE _CURVE() {
      try {
         {
            new ImageResource(this, "AboutIcon", null);
            new ImageResource(this, "Icon", null);
            new ImageResource(this, "OptionsIcon", null);
            new ImageResource(this, "RolloverIcon", null);
            new ImageResource(this, "RubberBandIcon", null);
            new ImageResource(this, "ServerSetupIcon", null);
            new ImageResource(this, "SplashImage", null);
            new ImageResource(this, "SplashImageLandscape", null);
            new ImageResource(this, "SplashImageLandscapeLeft", null);
            new ImageResource(this, "SplashImageLandscapeRight", null);
            new ImageResource(this, "SplashImagePortrait", null);
            new ImageResource(this, "SplashImageUpsideDown", null);
         }
         return this;
      } catch (Throwable _t_init_0) {
         throw new VScriptRuntimeException("_CURVE", _t_init_0);
      }
      
   }
   
}
