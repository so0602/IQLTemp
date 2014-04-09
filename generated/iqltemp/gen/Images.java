/////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2000-2014 Antenna Software Inc., All rights reserved //
//                                                                             //
// This file contains confidential information and is the                      //
// property of Antenna Software Inc., with all the restrictions                //
// therein.                                                                    //
/////////////////////////////////////////////////////////////////////////////////
package iqltemp.gen;
import  com.antennasoftware.api.foundation.vscript.VScriptRuntimeException;
import  com.antennasoftware.api.bl.images.BundleReference;
import  com.antennasoftware.api.bl.images.ImageReference;

public class Images extends com.antennasoftware.api.bl.images.Images {
   protected Images() {
      super();
      
   }
   
   public ImageReference AboutIcon;
   
   public ImageReference ButtonBackground;
   
   public ImageReference Icon;
   
   public ImageReference OptionsIcon;
   
   public ImageReference RolloverIcon;
   
   public ImageReference RubberBandIcon;
   
   public ImageReference ServerSetupIcon;
   
   public ImageReference SplashImage;
   
   public ImageReference SplashImageLandscape;
   
   public ImageReference SplashImageLandscapeLeft;
   
   public ImageReference SplashImageLandscapeRight;
   
   public ImageReference SplashImagePortrait;
   
   public ImageReference SplashImageUpsideDown;
   
   public BundleReference ANDROID;
   
   public BundleReference ANDROID_L;
   
   public BundleReference ANDROID_S;
   
   public BundleReference ANDROID_X;
   
   public BundleReference BOLD;
   
   public BundleReference CURVE;
   
   public BundleReference IPAD;
   
   public BundleReference IPHONE;
   
   public BundleReference PEARL;
   
   public BundleReference STORM;
   
   public BundleReference WM;
   
   protected Images _D_Images() {
      try {
         return this;
      } catch (Throwable _t_fini_0) {
         throw new VScriptRuntimeException("_D_Images", _t_fini_0);
      }
      
   }
   
   protected Images _Images() {
      try {
         this.AboutIcon = new ImageReference(this, "AboutIcon", null);
         this.ButtonBackground = new ImageReference(this, "ButtonBackground", null);
         this.Icon = new ImageReference(this, "Icon", null);
         this.OptionsIcon = new ImageReference(this, "OptionsIcon", null);
         this.RolloverIcon = new ImageReference(this, "RolloverIcon", null);
         this.RubberBandIcon = new ImageReference(this, "RubberBandIcon", null);
         this.ServerSetupIcon = new ImageReference(this, "ServerSetupIcon", null);
         this.SplashImage = new ImageReference(this, "SplashImage", null);
         this.SplashImageLandscape = new ImageReference(this, "SplashImageLandscape", null);
         this.SplashImageLandscapeLeft = new ImageReference(this, "SplashImageLandscapeLeft", null);
         this.SplashImageLandscapeRight = new ImageReference(this, "SplashImageLandscapeRight", null);
         this.SplashImagePortrait = new ImageReference(this, "SplashImagePortrait", null);
         this.SplashImageUpsideDown = new ImageReference(this, "SplashImageUpsideDown", null);
         this.ANDROID = new BundleReference(this, "iqltemp.gen.images.ANDROID");
         this.ANDROID_L = new BundleReference(this, "iqltemp.gen.images.ANDROID_L");
         this.ANDROID_S = new BundleReference(this, "iqltemp.gen.images.ANDROID_S");
         this.ANDROID_X = new BundleReference(this, "iqltemp.gen.images.ANDROID_X");
         this.BOLD = new BundleReference(this, "iqltemp.gen.images.BOLD");
         this.CURVE = new BundleReference(this, "iqltemp.gen.images.CURVE");
         this.IPAD = new BundleReference(this, "iqltemp.gen.images.IPAD");
         this.IPHONE = new BundleReference(this, "iqltemp.gen.images.IPHONE");
         this.PEARL = new BundleReference(this, "iqltemp.gen.images.PEARL");
         this.STORM = new BundleReference(this, "iqltemp.gen.images.STORM");
         this.WM = new BundleReference(this, "iqltemp.gen.images.WM");
         return this;
      } catch (Throwable _t_init_0) {
         throw new VScriptRuntimeException("_Images", _t_init_0);
      }
      
   }
   
}
