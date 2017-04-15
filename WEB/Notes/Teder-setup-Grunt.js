press . on bitbucket => search user permitted projects

README.TXT // for info on project setup

git clone address

git branch shay

git checkout shay

branch // see branches

// on package.json exists
	
	npm install
	
	npm start  /  sudo npm start
	
	// create package.json
		
		npm init  /  npm i (short cut)
		
		npm install dependencyName  --save
		
		// in package.json
			"scripts": {
				"start": "something"
			  }	// will lanch ^ on npm start
			  
	// if bower in grunt/gulp
	
	sudo bower install --allow-root
	
	// if bootstrap error
	
	npm install bootstrap
	
// on changes not showing
	// delete temp files grunt/gulp creates

		// GRUNT FILE 1
		
module.exports = function (grunt) {
  grunt.initConfig({
    sass: {
      options: {
        sourcemap: 'none'
      },
      app: {
        files: {
          'www/css/app.css': 'www/scss/app.scss',
        }
      },
    },
    cssmin: {
      app: {
        files: [{
          src: [
            'www/css/*.css',
            '!www/css/*.min.css',
          ],
          dest: 'www/css/app.min.css'
        }]
      },
      extensions: {
        files: [{
          src: [],
          dest: 'www/css/extensions.min.css'
        }]
      }
    },
    ngtemplates: {
      options: {
        htmlmin: {
          collapseBooleanAttributes: true,
			.....
				// add traits to the project all pages
        }
      },
      app: {
		  // link the html with js scripts
      }
    },
    uglify: {
      extensions: {
        files: {
          'www/js/extensions.min.js': [
            'node_modules/parse/dist/parse.js',
            'www/lib/ionic/js/ionic.bundle.js',
            'www/lib/ngCordova/dist/ng-cordova.js',
				// will all be put in extensions.min.js
				// if file in [] missing
					// 1
					// npm install dependancy --save
						// point source to node_modules/
					// 2
					// point to cdn source
					// 3
					// load file from html page
						// script src="........
          ]
        }
      },
      app: {
        files: {
          'www/js/app.min.js': [
            'www/js/app.js',
			..... // all will go into app.min.js
          ]
        }
      }
    },
    watch: {
      'app-sass': {
        files: 'www/scss/*.scss',
        tasks: ['sass:app', 'cssmin:app']
      }
	  // any changes in www/scss/*.scss
	  // will be updated to sass:app form section cssmin:app above
    }
  });
		
		// launch sections ^
  grunt.loadNpmTasks('grunt-contrib-sass');
  grunt.loadNpmTasks('grunt-contrib-cssmin');
  grunt.loadNpmTasks('grunt-angular-templates');
  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-contrib-watch');

  grunt.registerTask('default', ['sass', 'cssmin', 'ngtemplates', 'uglify', 'watch']);
};


	// GRUNT FILE 2
	
module.exports = function(grunt) {

    // Project configuration.
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        less: {
            development: {
                options: {
                    paths: ["css"]
                },
                files: {
                    "css/app.css": "less/app.less",
                },
                cleancss: true
            }
        },
        browserSync: {
          default_options: {
            bsFiles: {
              src: [
                "css/*.css",
                "*.html",
                "js/**/**/*.js",
                "views/**/*.html",
                "template/**/*.html"
              ]
            },
            options: {
              watchTask: true,
              server: {
                baseDir: "./"
              }
            }
          }
        },
        concat: {
            dist: {
                src: ['js/controllers/**/*.js', 'js/directives/*.js', 'js/services/*.js', 'js/filters/*.js'],
                dest: 'js/build.js',
				// dest ~ destination
            }	// all js code goes into build.js
        },
        csssplit: {
            your_target: {
                src: ['css/app.css'],
                dest: 'css/app.min.css',
                options: {
                    maxSelectors: 4095,
                    suffix: '.'
                }
            },
        },
        ngtemplates: {
          materialAdmin: {
            src: ['template/**/*.html', 'views/**/*.html'],
            dest: 'js/templates.js',
            options: {
              htmlmin: {
                    collapseWhitespace: true,
                    collapseBooleanAttributes: true
              }
            }
          }
        },
        watch: {
            ngtemplate: {
                files: ['template/**/*.html', 'views/**/*.html'],
                tasks: ['ngtemplates']
            },
            styles: {
                files: ['less/**/*.less'], // which files to watch
                tasks: ['less', 'csssplit'],
                options: {
                    nospawn: true
                }
            },
            scripts: {
                files: ['js/controllers/**/*.js', 'js/directives/*.js', 'js/services/*.js', 'js/filters/*.js'], // which files to watch
                tasks: ['concat'],
                options: {
                    nospawn: true
                }
            }
        }
    });

    // Load the plugin that provides the "less" task.
    grunt.loadNpmTasks('grunt-contrib-less');
    grunt.loadNpmTasks('grunt-csssplit');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-angular-templates');
    grunt.loadNpmTasks('grunt-browser-sync');

    // Default task(s).
    grunt.registerTask('default', ['browserSync', 'watch']); // error
		// add concat for the js angular files to be insync
	grunt.registerTask('default', ['browserSync', 'concat' ,'watch']);

};

//__________________ sideMenuPagesList  ______________________// 

{
	label: 'Library',
	icon: 'library',
	pages: [
		{
			label: 'Library treatments list',
			uiSref: 'library.home'
		},
		{
			label: 'Add library treatment',
			uiSref: 'library.add'
		}	// ^ similar to href
				// will go to js/controllers/libary/Addcontroller.js??
	]
}



//____________________ IONIC run commands ________________________//

sudo ionic state reset
	// install all the packages
sudo ionic build
	// build the project

// ANDROID
	// connect android to pc
		// android usb setting (file-transfer not charging)
	// check if connected -> adb devices
	sudo ionic run android
		// build project + launch in phone
		// errors => check adb
		adb devices // if empty reconnect phone to pc
		// ADB problems_____________________
		// phone settings => Developer => Allow ADB pops on connection
		// ./adb --help
		// sudo ionic state reset
	inspect elements in chrome
		Chrome://inspect
			// click on the device

// RUN APP IN BROWSER
	sudo ionic serve
	
// IPHONE
	// connect iphone to mac
	sudo ionic build ios
		// creates xcodeproj in platforms/ios folder
			// open ^ right click => Reveal in folder
				// 2x click fileName.xcodeproj
				// Apple Signing app => v on automatic => name...
				// press play button
				// open Safari developers...